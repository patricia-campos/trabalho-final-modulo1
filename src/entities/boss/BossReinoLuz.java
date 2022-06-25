package entities.boss;

import entities.cenario.Cenario;

import java.util.Random;

public class BossReinoLuz extends Boss{

    private int restaurarVida;

    Random random = new Random();

    public BossReinoLuz() {
    }

    public BossReinoLuz(String nome, int vida, int ataque, int defesa, Cenario reino) {
        super(nome, vida, ataque, defesa, reino);
    }

    public void recuperarVida() {
        restaurarVida = random.nextInt(10) + this.getVida();
        this.setVida(restaurarVida);
    }
}
