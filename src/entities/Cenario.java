package entities;

import controller.Batalha;

import java.util.Random;

public class Cenario {

    private String lugar;
    private String cor;
    private int round;
    private Personagem personagem;

    public void buffDebuff(Batalha batalha){
        Random random = new Random();
        int sortear = random.nextInt(5);

        if(batalha.getCenario() == reinoLuz){
            batalha.getPersonagem().setAtaque(batalha.getAtaque() + sortear);
            batalha.getBoss().setAtaque(batalha.getBoss().getAtaque() - sortear);
        }else if(batalha.getCenario() == reinoSombrio){
            batalha.getPersonagem().setAtaque(batalha.getAtaque() - sortear);
            batalha.getBoss().setAtaque(batalha.getBoss().getAtaque() + sortear);
        }
    }

}
