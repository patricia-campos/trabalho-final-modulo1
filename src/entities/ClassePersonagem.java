package entities;

public class ClassePersonagem {
    private String descricaoJogador;
    private int tipo; //1 - Mago / 2 - Elfo / 3 - Guerreira
    private int vidaJogador;
    private int defesaJogador;
    private int ataqueJogador;


    public ClassePersonagem(String descricaoJogador, int tipo, int vidaJogador, int defesaJogador, int ataqueJogador) {
        this.descricaoJogador = descricaoJogador;
        this.tipo = tipo;
        this.vidaJogador = vidaJogador;
        this.defesaJogador = defesaJogador;
        this.ataqueJogador = ataqueJogador;
    }

    public String getDescricaoJogador() {
        return descricaoJogador;
    }

    public void setDescricaoJogador(String descricaoJogador) {
        this.descricaoJogador = descricaoJogador;
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
}