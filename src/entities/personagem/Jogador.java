package entities.personagem;

import java.util.List;

public class Jogador {

    private String nomeJogador;
    private List<Personagem> personagem;



    public Jogador(String nomeJogador, Personagem personagem) {
        this.nomeJogador = nomeJogador;
        assert this.personagem != null;
        this.personagem.add(personagem);
    }

    public Jogador() {

    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public List<Personagem> getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem.add(personagem);
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "Nome do Jogador: " + nomeJogador + '\'' +
                '}';
    }
}
