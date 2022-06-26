package entities.personagem;

public class Personagem {
    private String nomePersonagem;
    private ClassePersonagem classePersonagem;

    public void personagem(){

    }
    public void personagem(String nomePersonagem, ClassePersonagem classePersonagem) {
        this.nomePersonagem = nomePersonagem;
        this.classePersonagem = classePersonagem;
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


    @Override
    public String toString() {
        return  "========================="
                +  getClassePersonagem()
                + "\n"+
                "=========================" ;
    }
}

