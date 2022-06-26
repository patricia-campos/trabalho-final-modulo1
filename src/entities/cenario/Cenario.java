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

        if(batalha.getCenario() == batalha.getReinoLuz()){
            batalha.getPersonagem().getClassePersonagem().setAtaqueClasse(batalha.getPersonagem().getClassePersonagem().getAtaqueClasse() + sortear);
            batalha.getBoss().setAtaque(batalha.getBoss().getAtaque() - sortear);
        }else if(batalha.getCenario() == batalha.getReinoSombrio()){
            batalha.getPersonagem().getClassePersonagem().setAtaqueClasse(batalha.getPersonagem().getClassePersonagem().getAtaqueClasse() - sortear);
            batalha.getBoss().setAtaque(batalha.getBoss().getAtaque() + sortear);
        }
    }

    @Override
    public void imprimir() {

    }
}
