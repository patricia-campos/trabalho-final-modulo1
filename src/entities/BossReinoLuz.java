package entities;

import java.util.Random;

public class BossReinoLuz extends Boss{

    private int restaurarVida;

    Random random = new Random();

    public BossReinoLuz() {
    }

    public BossReinoLuz(String nome, int vida, int ataque, int defesa, Cenario reino, int restaurarVida) {
        super(nome, vida, ataque, defesa, reino);
    }

    public void setRestaurarVida(int restaurarVida) {
        this.restaurarVida = restaurarVida;
    }

    public void recuperarVida(int vida) {
        restaurarVida = random.nextInt(10) + this.getVida();
        this.setVida(restaurarVida);
    }
}
