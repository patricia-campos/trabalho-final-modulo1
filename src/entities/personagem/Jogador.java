package entities.personagem;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

    private String nomeJogador;
    private List<Personagem> personagem = new ArrayList<>();



    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public List<Personagem> getPersonagem() {
        return personagem;
    }

    public void setPersonagem( Personagem personagem) {
        this.personagem.add(personagem);
    }

    public Jogador(String nomeJogador, Personagem personagem) {
        this.nomeJogador = nomeJogador;
        assert false;
        this.setPersonagem(personagem);
    }

    public Jogador() {

    }

    public Personagem retornaPersonagem(int index) {
        if (this.personagem.size() == 0) {
            return null;
        }
        if (this.personagem.size() > index) {
            return personagem.get(index);
        }
        return null;
    }

    public void listarPersonagens(Jogador jogador) {
        for (int i = 0; i < jogador.getPersonagem().size() ; i++) {
            System.out.println("id=" + i + "\n" + jogador.personagem.get(i));
        }
    }


    @Override
    public String toString() {
        return "========================="
                + "\n" +
                "| Nome do Jogador: " + nomeJogador
                + "\n" +
                "=========================";
    }
}
