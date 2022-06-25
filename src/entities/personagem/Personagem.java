package entities.personagem;

public class Personagem {
    private Jogador jogador;
    private String nomePersonagem;
    private ClassePersonagem classePersonagem;

    public Personagem(Jogador jogador, String nomePersonagem, ClassePersonagem classePersonagem) {
        this.jogador = jogador;
        this.nomePersonagem = nomePersonagem;
        this.classePersonagem = classePersonagem;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
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
        return "Personagem{" +
                "Jogador: " + getJogador() + '\'' +
                "Nome do Personagem: '" + nomePersonagem + '\'' +
                "Classe do Personagem: " + getClassePersonagem() +
                '}';
    }
}

