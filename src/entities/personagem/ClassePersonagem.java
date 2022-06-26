package entities.personagem;

import interfaces.Impressao;

public class ClassePersonagem implements Impressao {
    private int tipo; //1 - Mago / 2 - Elfo / 3 - Guerreira
    private int vidaJogador;
    private int defesaJogador;
    private int ataqueJogador;
    private String tipoNome;


    public ClassePersonagem() {
    }

    public ClassePersonagem(int tipo, int vidaJogador, int defesaJogador, int ataqueJogador, String tipoNome) {
        this.tipo = tipo;
        this.vidaJogador = vidaJogador;
        this.defesaJogador = defesaJogador;
        this.ataqueJogador = ataqueJogador;
        this.tipoNome = tipoNome;

    }

    @Override
    public String toString() {
        return  ""
                + "\n"+
                "| Nome da classe: " + tipoNome +
                "\n| Tipo da classe: " + tipo
                + "\n"+
                "| Vida da classe: " + vidaJogador
                + "\n"+
                "| Defesa da classe: " + defesaJogador
                + "\n"+
                "| Ataque da classe: " + ataqueJogador +
                "" ;
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

    public String getTipoNome() {
        return tipoNome;
    }

    public void setTipoNome(String tipoNome) {
        this.tipoNome = tipoNome;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
}
