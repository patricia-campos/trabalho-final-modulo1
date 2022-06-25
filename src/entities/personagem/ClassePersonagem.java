package entities.personagem;

import interfaces.Impressao;

public class ClassePersonagem implements Impressao {
    private int tipo; //1 - Mago / 2 - Elfo / 3 - Guerreira
    private int vidaJogador;
    private int defesaJogador;
    private int ataqueJogador;


    public ClassePersonagem(int tipo, int vidaJogador, int defesaJogador, int ataqueJogador) {
        this.tipo = tipo;
        this.vidaJogador = vidaJogador;
        this.defesaJogador = defesaJogador;
        this.ataqueJogador = ataqueJogador;
    }

    @Override
    public String toString() {
        return "Classe do Personagem:{" +
                "Tipo: " + tipo + '\'' +
                "Vida: " + vidaJogador +
                "Defesa: " + defesaJogador +
                "Ataque: " + ataqueJogador +
                '}';
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getVidaJogador() {
        return vidaJogador;
    }

    public void setVidaJogador(int vidaJogador) {
        this.vidaJogador = vidaJogador;
    }

    public int getDefesaJogador() {
        return defesaJogador;
    }

    public void setDefesaJogador(int defesaJogador) {
        this.defesaJogador = defesaJogador;
    }

    public int getAtaqueJogador() {
        return ataqueJogador;
    }

    public void setAtaqueJogador(int ataqueJogador) {
        this.ataqueJogador = ataqueJogador;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
}
