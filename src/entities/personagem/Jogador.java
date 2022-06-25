package entities.personagem;

public class Jogador {

    private String nomeJogador;
    private Personagem personagem;

    public Jogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "Nome do Jogador: " + nomeJogador + '\'' +
                "Nome do Personagem: '" + getPersonagem() + '\'' +
                '}';
    }
}