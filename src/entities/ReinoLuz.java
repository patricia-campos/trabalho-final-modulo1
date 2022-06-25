package entities;

import controller.Batalha;

import java.util.Random;

public class ReinoLuz extends Cenario{
    private String diaOuNoite;


    public void ajudaSoldados(Batalha batalha){
        Random random = new Random();
        int sortear = random.nextInt(4);
        if(batalha.getRoundAtual() == 3){
            boss.setVida(boss.getVida - sortear);
        }
    }

    public void bonusHorario(Batalha batalha){
        Random random = new Random();
        int sortear = random.nextInt(5);
        if(this.diaOuNoite == "dia"){
            batalha.getPersonagem().setVida(batalha.getPersonagem().getVida + sortear);
        }else if(this.diaOuNoite == "noite"){
            batalha.getBoss().setVida(batalha.getBoss().getVida + sortear);
        }
    }

}
