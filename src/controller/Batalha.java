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
    private final ReinoLuz reinoLuz = new ReinoLuz();
    private final ReinoSombrio reinoSombrio = new ReinoSombrio();
    private Personagem personagem = new Personagem();
    private Boss boss = new Boss();
    private final BossReinoLuz bossLuz = new BossReinoLuz("Boss Luz",this.cenario);
    private final BossReinoSombrio bossSombrio = new BossReinoSombrio("Boss Sombrio",this.cenario);
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
                setBoss(bossLuz);
            }
            case 2 -> {
                this.cenario = reinoSombrio;
                setBoss(bossSombrio);

            }
            case default -> System.out.println("Cenario Invalido");
        }
    }

    public void inciarBatalha(){
        if(this.boss == bossLuz){
            System.out.println("Boss da Luz está chegando");
        }else{
            System.out.println("Boss da Sombras está chegando");
        }if(this.boss.getVida() <= 0){
            System.out.println("Vitoria a luta acabou você matou o boss");
        }else if(this.getPersonagem().getClassePersonagem().getVidaClasse() == 0){
            System.out.println("Derrota o boss te matou");
        }
            setRoundAtual(roundAtual++);
            if (this.boss == bossLuz) {
                if (this.boss.getVida() <= 0) {
                    System.out.println("Vitoria");
                }else if (this.getPersonagem().getClassePersonagem().getVidaClasse() <= 0) {
                    System.out.println("Derrota pois nao tirou a vida toda do boss");
                }
                System.out.println(bossLuz.recuperarVida());
                reinoLuz.ajudaSoldados(this);
                reinoLuz.bonusHorario(this);
                cenario.buffDebuff(this);
                this.atacar();
                this.ataqueBoss();
                System.out.println(this.imprimiStatusJogador() +" ----------------- "+ this.imprimiStatusBoss()+"\n\n\n");

            } else if (this.boss == bossSombrio) {
                if(this.boss.getVida() <= 0){
                    System.out.println("Vitoria");
                }else if(this.getPersonagem().getClassePersonagem().getVidaClasse() <= 0){
                    System.out.println("Derrota pois nao tirou a vida toda do boss");
                }
                System.out.println(bossSombrio.getVida());
                cenario.buffDebuff(this);
                bossSombrio.danoAdicional();
                reinoSombrio.ajudaSombria(this);
                this.atacar();
                this.ataqueBoss();
                System.out.println(this.imprimiStatusJogador() +" ----------------- "+ this.imprimiStatusBoss()+"\n\n\n");
            }
    }

    @Override
    public void atacar() {

        Random random = new Random();
        int valor = random.nextInt(10);
        int atqJogador = this.personagem.getClassePersonagem().getAtaqueClasse();
        int vidaBoss = this.boss.getVida();
        int defesaBoss = this.boss.getDefesa();
        int valorAtq = atqJogador + valor;
        if(valor <= 2) {
            System.out.println("O boss desviou do seu ataque");
            System.out.println("\n");
        }else {
            System.out.println("Ataque bem sucedido");
            System.out.println("\n");
            this.boss.setVida(vidaBoss + defesaBoss - valorAtq );
        }
    }

    public String imprimiStatusJogador(){
        String nome = this.getPersonagem().getClassePersonagem().getTipoNome();
        int vida = this.getPersonagem().getClassePersonagem().getVidaClasse();
        int ataque = this.getPersonagem().getClassePersonagem().getAtaqueClasse();
        int defesa = this.getPersonagem().getClassePersonagem().getDefesaClasse();
        return "Personagem: " + nome + " Vida: "+vida+" Ataque: "+ataque + " Defesa "+defesa;
    }

    public String imprimiStatusBoss(){
        String nome = this.getBoss().getNome();
        int vida = this.getBoss().getVida();
        int ataque = this.getBoss().getAtaque();
        int defesa = this.getBoss().getDefesa();
        return "Boss: " + nome + " Vida: "+vida+" Ataque: "+ataque + " Defesa: "+defesa;
    }

    @Override
    public void ataqueBoss() {

        Random random = new Random();
        int valor = random.nextInt(10);
        int vidaJogador = this.personagem.getClassePersonagem().getVidaClasse();
        int atqBoss = this.boss.getAtaque();
        int valorAtq = atqBoss + valor;
        if(valor <= 3) {
            System.out.println("Você desviou do ataque do boss");
        }else {
            this.personagem.getClassePersonagem().setVidaClasse(vidaJogador - valorAtq);
        }
    }
}
