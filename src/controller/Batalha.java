package controller;

import entities.boss.Boss;
import entities.boss.BossReinoLuz;
import entities.boss.BossReinoSombrio;
import entities.cenario.Cenario;
import entities.cenario.ReinoLuz;
import entities.cenario.ReinoSombrio;
import entities.personagem.Personagem;
import interfaces.Ataca;

import java.util.Random;

public class Batalha implements Ataca {

    private Cenario cenario = new Cenario();
    private ReinoLuz reinoLuz = new ReinoLuz();
    private ReinoSombrio reinoSombrio = new ReinoSombrio();
    private Personagem personagem = new Personagem();
    private Boss boss = new Boss();
    private BossReinoLuz bossLuz = new BossReinoLuz();
    private BossReinoSombrio bossSombrio = new BossReinoSombrio();
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
        Random random = new Random();
        int sortear = random.nextInt(2) + 1;
        switch (sortear) {
            case 1 -> {
                this.cenario = reinoLuz;
                bossLuz.recuperarVida();
                this.boss = bossLuz;
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
        for(int roundAtual = 0; roundAtual < 10; roundAtual++)
        if(this.boss == bossLuz){
            bossLuz.recuperarVida();
            reinoLuz.ajudaSoldados(this);
            this.atacar();
            this.ataqueBoss();
            reinoLuz.bonusHorario(this);
            cenario.buffDebuff(this);
        }else if(this.boss == bossSombrio){
            bossSombrio.danoAdicional();
            reinoSombrio.ajudaSombria(this);
            this.atacar();
            this.ataqueBoss();
            cenario.buffDebuff(this);
        }
    }

    @Override
    public void atacar() {
        Random random = new Random();
        int valor = random.nextInt(10);
        int atqJogador = this.personagem.getClassePersonagem().getAtaqueJogador();
        int vidaBoss = this.boss.getVida();
        int valorAtq = atqJogador + valor;
        if(valor <= 2) {
            System.out.println("O boss desviou do seu ataque");
        }else {
            System.out.println("Ataque bem sucedido");
            System.out.println("Dano: "+ valorAtq);
            this.boss.setVida(vidaBoss - valorAtq);
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
            System.out.println("Ataque bem  do boss");
            System.out.println("Dano: "+ valorAtq);
            this.boss.setVida(vidaJogador - valorAtq);
        }
    }
}
