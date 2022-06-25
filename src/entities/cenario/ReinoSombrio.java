package entities.cenario;

import controller.Batalha;

import java.util.Random;

public class ReinoSombrio extends Cenario{
    private String malCheiro;


    public void ajudaSombria(Batalha batalha){
        Random random = new Random();
        int sortear = random.nextInt(7);
        if(batalha.getRoundAtual() == sortear){
            System.out.println("A ajuda sombria te atacou enquanto você estava desatento e você perdeu " +sortear + " de vida");
            batalha.getPersonagem().getClassePersonagem().setVidaJogador(batalha.getPersonagem().getClassePersonagem().getVidaJogador() - sortear);
        }
    }

    public void armadilha(Batalha batalha){
        Random random = new Random();
        int sortear = random.nextInt(7);
        if(batalha.getRoundAtual() == sortear){
            System.out.println("Você deu um passo e não percebeu que tinha uma armadilha menos " +sortear + " de vida");
            batalha.getPersonagem().getClassePersonagem().setVidaJogador(batalha.getPersonagem().getClassePersonagem().getVidaJogador() - sortear);
        }

    }
}
