package entities.boss;

import entities.cenario.Cenario;

import java.util.Random;

public class BossReinoLuz extends Boss{

    private int restaurarVida;

    Random random = new Random();

    public BossReinoLuz(String nome, Cenario reino) {
        super(nome, reino);
        this.setVida(300);
        this.setAtaque(10);
        this.setDefesa(10);
    }

    public void recuperarVida() {
        restaurarVida = random.nextInt(10) + this.getVida();
        this.setVida(restaurarVida);
    }
}
