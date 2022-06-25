package entities;

import java.util.Random;

public class Cenario {

    private String lugar;
    private String cor;
    private int round;
    private Personagem personagem;

    public void buffDebuff(Cenario cenario,Boss boss, Personagem personagem){
        Random random = new Random();
        int sortear = random.nextInt(5);

        if(cenario == reinoLuz){
            personagem.setAtaque(personagem.getAtaque() + sortear);
            boss.setAtaque(boss.getAtaque() - sortear);
        }else if(cenario == reinoSombrio){
            boss.setAtaque(boss.getAtaque() + sortear);
            personagem.setAtaque(personagem.getAtaque() - sortear);
        }
    }

}
