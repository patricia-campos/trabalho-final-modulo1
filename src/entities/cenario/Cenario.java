package entities.cenario;

import controller.Batalha;
import interfaces.Impressao;

import java.util.Random;

public class Cenario implements Impressao {

    ReinoLuz reinoLuz;
    ReinoSombrio reinoSombrio;

    public void buffDebuff(Batalha batalha){

        Random random = new Random();
        int sortear = random.nextInt(5);

        if(batalha.getCenario() == reinoLuz){
            batalha.getPersonagem().getClassePersonagem().setAtaqueJogador(batalha.getPersonagem().getClassePersonagem().getAtaqueJogador() + sortear);
            batalha.getBoss().setAtaque(batalha.getBoss().getAtaque() - sortear);
        }else if(batalha.getCenario() == reinoSombrio){
            batalha.getPersonagem().getClassePersonagem().setAtaqueJogador(batalha.getPersonagem().getClassePersonagem().getAtaqueJogador() - sortear);
            batalha.getBoss().setAtaque(batalha.getBoss().getAtaque() + sortear);
        }
    }

    @Override
    public void imprimir() {

    }
}
