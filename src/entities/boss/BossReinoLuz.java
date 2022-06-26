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

        int sortear = random.nextInt(10);
        restaurarVida = sortear + this.getVida();
        System.out.println("Poder especial restaura " + sortear + " vida do Boss");
        this.setVida(restaurarVida);
    }
}
