package controller;

import entities.Cenario;
import entities.ReinoLuz;
import entities.ReinoSombrio;

import java.util.Random;

public class Batalha {
    Cenario cenario;
    private Personagem personagem;
    private Boss boss;
    private int roundAtual;

    public void sortearCenario(){
        Random random = new Random();
        int sortear = random.nextInt(2);
        switch (sortear){
            case 1:
                this.cenario = new ReinoLuz();
                this.boss = new BossLuz();
                break;
            case 2:
                this.cenario = new ReinoSombrio();
                this.boss = new BossSombrio();
                break;
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
