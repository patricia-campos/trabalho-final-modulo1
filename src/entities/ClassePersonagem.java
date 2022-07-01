package entities;

import interfaces.Impressao;

public class ClassePersonagem implements Impressao {
    private int tipo; //1 - Mago / 2 - Elfo / 3 - Guerreira
    private int vidaClasse;
    private int defesaClasse;
    private int ataqueClasse;
    private String tipoNome;

    public ClassePersonagem() {
    }

    public ClassePersonagem(int tipo, int vidaClasse, int defesaClasse, int ataqueClasse, String tipoNome) {
        this.tipo = tipo;
        this.vidaClasse = vidaClasse;
        this.defesaClasse = defesaClasse;
        this.ataqueClasse = ataqueClasse;
        this.tipoNome = tipoNome;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getVidaClasse() {
        return vidaClasse;
    }

    public void setVidaClasse(int vidaClasse) {
        if (vidaClasse < 0) {
            this.vidaClasse = 0;
        } else {
            this.vidaClasse = vidaClasse;
        }
    }

    public int getDefesaClasse() {
        return defesaClasse;
    }

    public void setDefesaClasse(int defesaClasse) {
        this.defesaClasse = defesaClasse;
    }

    public int getAtaqueClasse() {
        return ataqueClasse;
    }

    public void setAtaqueClasse(int ataqueClasse) {
        this.ataqueClasse = ataqueClasse;
    }

    public String getTipoNome() {
        return tipoNome;
    }

    public void setTipoNome(String tipoNome) {
        this.tipoNome = tipoNome;
    }

    @Override
    public String toString() {
        return "\n" +
                "" +
                "| Nome da classe: " + tipoNome +
                "\n| Tipo da classe: " + tipo
                + "\n" +
                "| Vida da classe: " + vidaClasse
                + "\n" +
                "| Defesa da classe: " + defesaClasse
                + "\n" +
                "| Ataque da classe: " + ataqueClasse +
                "";
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
}
