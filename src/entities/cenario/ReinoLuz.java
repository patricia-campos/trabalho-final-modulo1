package entities.cenario;

import controller.Batalha;

import java.util.Random;

public class ReinoLuz extends Cenario{
    private String diaOuNoite;


    public void ajudaSoldados(Batalha batalha){
        Random random = new Random();
        int sortear = random.nextInt(4);
        if(batalha.getRoundAtual() == 3){
            batalha.getBoss().setVida(batalha.getBoss().getVida() - sortear);
        }
    }

    public void bonusHorario(Batalha batalha){
        Random random = new Random();
        int sortear = random.nextInt(5);
        if(this.diaOuNoite == "dia"){
            batalha.getPersonagem().getClassePersonagem().setVidaJogador(batalha.getPersonagem().getClassePersonagem().getVidaJogador() + sortear);
        }else if(this.diaOuNoite == "noite"){
            batalha.getBoss().setVida(batalha.getBoss().getVida() + sortear);
        }
    }
    @Override
    public void imprimir() {
        System.out.println(this.reinoLuz);
    }

    @Override
    public String toString() {
        return """
                O Cenario da luz traz um lugar iluminado em mundo aberto
                Lugar aberto com muitas arvores e vida
                Um lugar iluminado
                """;
    }

}
