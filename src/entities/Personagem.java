package entities;

import entities.ClassePersonagem;

public class Personagem {

    private int id;
    private String nomePersonagem;
    private ClassePersonagem classePersonagem = new ClassePersonagem();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public ClassePersonagem getClassePersonagem() {
        return classePersonagem;
    }

    public void setClassePersonagem(ClassePersonagem classePersonagem) {
        this.classePersonagem = classePersonagem;
    }

    public Personagem() {
    }

    public Personagem(int id,String nomePersonagem) {
        this.setNomePersonagem(nomePersonagem);
        this.setId(id);
    }
    public Personagem(String nomePersonagem) {
        this.setNomePersonagem(nomePersonagem);
    }

    public ClassePersonagem addClasse(int tipo) {
        if (tipo == 1) {
            classePersonagem.setTipoNome("Mago");
            classePersonagem.setTipo(1);
            classePersonagem.setAtaqueClasse(40);
            classePersonagem.setVidaClasse(150);
            classePersonagem.setDefesaClasse(50);
            return this.classePersonagem;

        } else if (tipo == 2) {
            classePersonagem.setTipoNome("Elfo");
            classePersonagem.setTipo(2);
            classePersonagem.setAtaqueClasse(50);
            classePersonagem.setVidaClasse(150);
            classePersonagem.setDefesaClasse(50);
            return this.classePersonagem;
        } else if (tipo == 3) {
            classePersonagem.setTipoNome("Guerreiro");
            classePersonagem.setTipo(3);
            classePersonagem.setAtaqueClasse(50);
            classePersonagem.setVidaClasse(150);
            classePersonagem.setDefesaClasse(40);
            return this.classePersonagem;
        } else {
            System.out.println("O tipo selecionado é inválido!");
        }
        return null;
    }


    @Override
    public String toString() {
        return "========================="
                + "\nNome do seu personagem: " + nomePersonagem
                + "\n Classe do personagem: " + getClassePersonagem()
                + "\n" +
                "=========================";
    }
}

