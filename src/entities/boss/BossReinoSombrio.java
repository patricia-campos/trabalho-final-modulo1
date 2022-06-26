package entities.boss;

import controller.Batalha;
import entities.cenario.Cenario;

import java.util.Random;

public class BossReinoSombrio extends Boss{

    private int danoAdicional;

    Random random = new Random();



    public BossReinoSombrio(String nome, Cenario reino) {
        super(nome, reino);
        this.setVida(300);
        this.setAtaque(35);
        this.setDefesa(10);
    }

    public String danoAdicional(Batalha batalha) {
        int sortear = random.nextInt(10);
        danoAdicional = sortear + batalha.getBoss().getAtaque();
        batalha.getBoss().setAtaque(danoAdicional);
        return "O boss ganhou um adicional "+sortear+" de ataque";
    }

}
