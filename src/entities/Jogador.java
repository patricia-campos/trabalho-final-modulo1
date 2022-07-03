package entities;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

    private int id;
    private String nomeJogador;
    private String senha;
    private int personagem;

    public String getSenha() {
        return senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public Jogador(String nomeJogador, String senha) {
        this.setNomeJogador(nomeJogador);
        this.setSenha(senha);
    }
    public Jogador(int id, String nomeJogador, String senha) {
        this.setNomeJogador(nomeJogador);
        this.setSenha(senha);
        this.setId(id);
    }
    public Jogador() {

    }

    public Personagem retornaPersonagem(int index) {

        return null;
    }

    public void listarPersonagens(Jogador jogador) {

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
