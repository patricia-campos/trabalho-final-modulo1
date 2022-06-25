package controller;

import entities.boss.Boss;
import entities.boss.BossReinoLuz;
import entities.boss.BossReinoSombrio;
import entities.cenario.Cenario;
import entities.cenario.ReinoLuz;
import entities.cenario.ReinoSombrio;
import entities.personagem.Personagem;

import java.util.Random;

public class Batalha {
    Cenario cenario;
    private Personagem personagem;
    private Boss boss;
    private int roundAtual;

    public void sortearCenario(){
        Random random = new Random();
        int sortear = random.nextInt(2);
        switch (sortear) {
            case 1 -> {
                this.cenario = new ReinoLuz();
                this.boss = new BossReinoLuz();
            }
            case 2 -> {
                this.cenario = new ReinoSombrio();
                this.boss = new BossReinoSombrio();
            }
            case default -> System.out.println("Cenario Invalido");
        }
    }

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
}
