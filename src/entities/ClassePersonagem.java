package entities;

import interfaces.Impressao;

public class ClassePersonagem implements Impressao {
    private int idClassePersonagem;
    private String nomeClassePersonagem;
    private int vidaClasse;
    private int defesaClasse;
    private int ataqueClasse;

    public ClassePersonagem(String nomeClassePersonagem, int vidaClasse, int defesaClasse, int ataqueClasse) {

        this.nomeClassePersonagem = nomeClassePersonagem;
        this.vidaClasse = vidaClasse;
        this.defesaClasse = defesaClasse;
        this.ataqueClasse = ataqueClasse;
    }

    public int getIdClassePersonagem() {
        return idClassePersonagem;
    }

    public void setIdClassePersonagem(int idClassePersonagem) {
        this.idClassePersonagem = idClassePersonagem;
    }

    public String getNomeClassePersonagem() {
        return nomeClassePersonagem;
    }

    public void setNomeClassePersonagem(String nomeClassePersonagem) {
        this.nomeClassePersonagem = nomeClassePersonagem;
    }

    public ClassePersonagem() {
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



    @Override
    public String toString() {
        return "\n" +
                "" +
                "| Nome da classe: " + nomeClassePersonagem +
                 "\n" +
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
