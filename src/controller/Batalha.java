package controller;

import entities.boss.Boss;
import entities.boss.BossReinoLuz;
import entities.boss.BossReinoSombrio;
import entities.cenario.Cenario;
import entities.cenario.ReinoLuz;
import entities.cenario.ReinoSombrio;
import entities.personagem.Personagem;
import exceptions.VerificarNulls;
import interfaces.Ataca;

import java.util.Random;

public class Batalha implements Ataca {

    private Cenario cenario = new Cenario();
    private ReinoLuz reinoLuz = new ReinoLuz();
    private ReinoSombrio reinoSombrio = new ReinoSombrio();
    private Personagem personagem = new Personagem();
    private Boss boss = new Boss();
    private BossReinoLuz bossLuz = new BossReinoLuz("Boss Luz",this.cenario);
    private BossReinoSombrio bossSombrio = new BossReinoSombrio("Boss Sombrio",this.cenario);
    private int roundAtual = 0;

    public Cenario getCenario() {
        return cenario;
    }

    public void setCenario(Cenario cenario) {
        this.cenario = cenario;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public int getRoundAtual() {
        return roundAtual;
    }

    public void setRoundAtual(int roundAtual) {
        this.roundAtual = roundAtual;
    }

    public void sortearCenario(){
        if(this.personagem == null){
            System.out.println("Não a personagem para batalha");
        }
        Random random = new Random();
        int sortear = random.nextInt(2) + 1;
        switch (sortear) {
            case 1 -> {
                setCenario(reinoLuz);
                bossLuz.recuperarVida();
                setBoss(bossLuz);
            }
            case 2 -> {
                this.cenario = reinoSombrio;
                bossSombrio.danoAdicional();
                this.boss = bossSombrio;

            }
            case default -> System.out.println("Cenario Invalido");
        }
    }

    public void inciarBatalha(){

        if(this.boss == bossLuz){
            System.out.println("Boss da Luz está chegando");
        }else{
            System.out.println("Boss da Sombras está chegando");
        }
        for(int i = 0; 0 != this.boss.getVida() || 0 != this.personagem.getClassePersonagem().getVidaJogador(); i++) {
            roundAtual++;
            if (this.boss == bossLuz) {
                System.out.println("Round " +i);
                System.out.println("A vida inicial do boss e de: " +bossLuz.getVida());
                bossLuz.recuperarVida();
                reinoLuz.ajudaSoldados(this);
                this.atacar();
                if(this.boss.getVida() <= 0){
                    System.out.println("Vida do boss "+this.boss.getVida());
                    System.out.println("Vitoria");
                    break;
                }
                this.ataqueBoss();
                if(this.getPersonagem().getClassePersonagem().getVidaJogador() <= 0){
                    System.out.println("Vida do jogador " +this.personagem.getClassePersonagem().getVidaJogador());
                    System.out.println("Derrota pois nao tirou a vida toda do boss");
                    break;
                }
                reinoLuz.bonusHorario(this);
                cenario.buffDebuff(this);
                System.out.println("Vida do Personagem: "+this.personagem.getClassePersonagem().getVidaJogador());
                System.out.println("Vida atual do boss: " + this.boss.getVida());
            } else if (this.boss == bossSombrio) {
                System.out.println(bossSombrio.getVida());

                System.out.println("Round " +i);
                bossSombrio.danoAdicional();
                reinoSombrio.ajudaSombria(this);
                this.atacar();
                if(this.boss.getVida() <= 0){
                    System.out.println("Vitoria");
                    break;
                }
                this.ataqueBoss();
                if(this.getPersonagem().getClassePersonagem().getVidaJogador() <= 0){
                    System.out.println("Derrota pois nao tirou a vida toda do boss");
                    break;
                }
                cenario.buffDebuff(this);
                System.out.println("Vida do Personagem: "+this.personagem.getClassePersonagem().getVidaJogador());
                System.out.println("Vida atual do boss: " + this.boss.getVida());
            }
        }
    }

    @Override
    public void atacar() {

        Random random = new Random();
        int valor = random.nextInt(10);
        int atqJogador = this.personagem.getClassePersonagem().getAtaqueJogador();
        int vidaBoss = this.boss.getVida();
        int defesaBoss = this.boss.getDefesa();
        int valorAtq = atqJogador + valor;
        if(valor <= 2) {
            System.out.println("O boss desviou do seu ataque");
            System.out.println("\n");
        }else {
            System.out.println("Ataque bem sucedido");
            System.out.println("Dano: "+ valorAtq);
            System.out.println("Defesa do boss: " + defesaBoss);
            System.out.println("\n");
            this.boss.setVida(vidaBoss - valorAtq - defesaBoss);
        }
    }

    @Override
    public void ataqueBoss() {

        Random random = new Random();
        int valor = random.nextInt(10);
        int vidaJogador = this.personagem.getClassePersonagem().getVidaJogador();
        int atqBoss = this.boss.getAtaque();
        int valorAtq = atqBoss + valor;
        if(valor <= 3) {
            System.out.println("Você desviou do ataque do boss");
        }else {
            System.out.println("Ataque bem sucedito do boss");
            System.out.println("Dano: "+ valorAtq);
            this.personagem.getClassePersonagem().setVidaJogador(vidaJogador - valorAtq);
        }
    }
}
