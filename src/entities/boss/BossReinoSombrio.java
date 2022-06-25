package entities.boss;

import entities.cenario.Cenario;

import java.util.Random;

public class BossReinoSombrio extends Boss{

    private int danoAdicional;

    Random random = new Random();



    public BossReinoSombrio(String nome, Cenario reino) {
        super(nome, reino);
        this.setVida(300);
        this.setAtaque(10);
        this.setDefesa(10);
    }

    public void danoAdicional() {
        danoAdicional = random.nextInt(10) + this.getAtaque();
        this.setAtaque(danoAdicional);
    }

}
