package entities.boss;

import entities.cenario.Cenario;

import java.util.Random;

public class BossReinoSombrio extends Boss{

    private int danoAdicional;

    Random random = new Random();

    public BossReinoSombrio() {

    }

    public BossReinoSombrio(String nome, int vida, int ataque, int defesa, Cenario reino) {
        super(nome, vida, ataque, defesa, reino);
    }

    public void danoAdicional() {
        danoAdicional = random.nextInt(10) + this.getAtaque();
        this.setAtaque(danoAdicional);
    }

}
