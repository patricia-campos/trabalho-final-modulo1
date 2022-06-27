package entities.boss;

import controller.Batalha;

import java.util.Random;

public class BossReinoSombrio extends Boss {

    private int danoAdicional;

    Random random = new Random();

    public BossReinoSombrio() {
        this.setNome("Boss Sombrio");
        this.setVida(300);
        this.setAtaque(25);
        this.setDefesa(10);
    }

    public String danoAdicional(Batalha batalha) {
        int sortear = random.nextInt(4);
        danoAdicional = sortear + batalha.getBoss().getAtaque();
        batalha.getBoss().setAtaque(danoAdicional);
        return "O boss ganhou um adicional de " + sortear + " de ataque";
    }

}
