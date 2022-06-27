package entities.cenario;

import controller.Batalha;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ReinoLuz extends Cenario{

    private String diaOuNoite;


    public void ajudaSoldados(Batalha batalha){
        Random random = new Random();
        int sortear = random.nextInt(4);
        if(batalha.getRoundAtual() == 3){
            System.out.println("Os soldados da Luz chegaram e tiraram " + sortear + " de vida do boss");
            batalha.getBoss().setVida(batalha.getBoss().getVida() - sortear);
        }
    }

    public void bonusHorario(Batalha batalha){
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        Date dataAtual = new Date();
        Random random = new Random();
        int sortear = random.nextInt(5);
        int horaAtual = Integer.parseInt(sdf.format(dataAtual));
        if(horaAtual >= 6 && horaAtual < 18){
            diaOuNoite = "dia";
            System.out.println("Como está de dia você ganhou um bonus de "+ sortear +" de vida");
            batalha.getPersonagem().getClassePersonagem().setVidaClasse(batalha.getPersonagem().getClassePersonagem().getVidaClasse() + sortear);
        }else {
            diaOuNoite = "noite";
            System.out.println("Como está de noite o boss ganhou "+ sortear +" de vida");
            batalha.getBoss().setVida(batalha.getBoss().getVida() + sortear);
        }
    }

    @Override
    public void buffDebuff(Batalha batalha){
        Random random = new Random();
        int sortear = random.nextInt(2) +1;
        System.out.println("Reino da luz traz um bonus de "+sortear+" ataque para o jogador e retira o mesmo tanto de ataque do boss");
        batalha.getPersonagem().getClassePersonagem().setAtaqueClasse(batalha.getPersonagem().getClassePersonagem().getAtaqueClasse() + sortear);
        batalha.getBoss().setAtaque(batalha.getBoss().getAtaque() - sortear);
    }
    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return """
                O Cenário da luz traz um lugar iluminado em mundo aberto
                Lugar aberto com muitas arvores e vida.
                """;
    }

}
