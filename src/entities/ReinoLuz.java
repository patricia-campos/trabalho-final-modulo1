package entities;

import controller.Batalha;

public class ReinoLuz extends Cenario{
    private String diaOuNoite;


    public void ajudaSoldados(Batalha batalha,Boss boss){
        if(batalha.getRoundAtual() == 3){
            boss.setVida(boss.getVida - 3);
        }
    }

    public void bonusHorario(Personagem person, Boss boss){
        if(this.diaOuNoite == "dia"){
            person.setVida(person.getVida + 5);
        }else if(this.diaOuNoite == "noite"){
            boss.setVida(boss.getVida + 5);
        }
    }

}
