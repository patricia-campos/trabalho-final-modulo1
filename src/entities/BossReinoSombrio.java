package entities;

import java.util.Random;

public class BossReinoSombrio extends Boss{

    private int danoAdicional;

    Random random = new Random();

    public BossReinoSombrio() {

    }

    public BossReinoSombrio(String nome, int vida, int ataque, int defesa, Cenario reino, int danoAdicional) {
        super(nome, vida, ataque, defesa, reino);
        this.danoAdicional = danoAdicional;
    }
}
