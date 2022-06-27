package entities.boss;

import controller.Batalha;

import java.util.Random;

public class BossReinoLuz extends Boss{

    private int restaurarVida;

    Random random = new Random();

    public BossReinoLuz() {
        this.setNome("Boss da Luz");
        this.setVida(300);
        this.setAtaque(35);
        this.setDefesa(10);
    }

    public String recuperarVida() {
        Batalha batalha = new Batalha();

        int sortear = random.nextInt(10);
        restaurarVida = sortear + batalha.getBoss().getVida();
        batalha.getBoss().setVida(restaurarVida);
        return "O boss restaurou "+sortear+" de vida";
    }
}
