package entities.personagem;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

    private String nomeJogador;
    private List<Personagem> personagem = new ArrayList<>();





    public Jogador(String nomeJogador, Personagem personagem) {
        this.nomeJogador = nomeJogador;
        assert this.personagem != null;
        this.personagem.add(personagem);
    }

    public Jogador() {

    }
    public Personagem retornaPersonagem(int index){
        if(this.personagem.size() == 0){
            return null;

        }
        return personagem.get(index);
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
    public void listarPersonagens() {
        for (int i = 0; i < personagem.size(); i++) {
            System.out.println("id=" + i + " | " + personagem.get(i));
        }
    }


    @Override
    public String toString() {
        return  "========================="
                + "\n"+
                "| Nome do Jogador: " + nomeJogador
                + "\n"+
                "=========================" ;
    }
}
