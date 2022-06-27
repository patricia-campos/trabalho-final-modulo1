package entities.cenario;

import controller.Batalha;

import java.util.Random;

public class ReinoSombrio extends Cenario {

    public void ajudaSombria(Batalha batalha) {
        Random random = new Random();
        int sortear = random.nextInt(7) + 1;
        if (batalha.getRoundAtual() == sortear) {
            System.out.println("A ajuda sombria te atacou enquanto você estava desatento e você perdeu " + sortear + " de vida");
            batalha.getPersonagem().getClassePersonagem().setVidaClasse(batalha.getPersonagem().getClassePersonagem().getVidaClasse() - sortear);
        }
    }

    public void armadilha(Batalha batalha) {
        Random random = new Random();
        int sortear = random.nextInt(7) + 1;
        if (batalha.getRoundAtual() == sortear) {
            System.out.println("Você deu um passo e não percebeu que tinha uma armadilha menos " + sortear + " de vida");
            batalha.getPersonagem().getClassePersonagem().setVidaClasse(batalha.getPersonagem().getClassePersonagem().getVidaClasse() - sortear);
        }

    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public void buffDebuff(Batalha batalha) {
        Random random = new Random();
        int sortear = random.nextInt(2) + 1;
        System.out.println("Reino das Sombras traz um bonus de " + sortear + " ataque para o boss e retira o mesmo tanto de ataque do jogador");
        batalha.getPersonagem().getClassePersonagem().setAtaqueClasse(batalha.getPersonagem().getClassePersonagem().getAtaqueClasse() - sortear);
        batalha.getBoss().setAtaque(batalha.getBoss().getAtaque() + sortear);
    }

    @Override
    public String toString() {
        return """
                O Cenario Sombrio traz um lugar obscuro com muitos monstros e bruxas
                Lugar fechado com muitas arvores secas e muita destruição
                Um lugar tenebroso com muitos corvos
                """;
    }
}
