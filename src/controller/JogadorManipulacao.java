package controller;

import java.util.ArrayList;

import entities.personagem.ClassePersonagem;
import entities.personagem.Jogador;
import entities.personagem.Personagem;
import interfaces.Impressao;

import java.util.List;


public class JogadorManipulacao implements Impressao {

    private List<Jogador> listaDeJogadores = new ArrayList<>();

    public List<Jogador> getListaDeJogadores() {
        return listaDeJogadores;
    }

    public void setListaDeJogadores(List<Jogador> listaDeJogadores) {
        this.listaDeJogadores = listaDeJogadores;
    }

    public JogadorManipulacao() {
        this.listaDeJogadores = new ArrayList<>();
    }

    public void adicionarJogador(Jogador jogador) {
        this.listaDeJogadores.add(jogador);
    }

    public void addPersonagem(Jogador jogador, Personagem personagem) {
        jogador.setPersonagem(personagem);
    }

    public Jogador retornarJogador(int index) {
        if (listaDeJogadores.size() > index) {
            return listaDeJogadores.get(index);
        }
        return null;
    }

    public Personagem retornaPersonagem(Jogador jogador, int index) {
        return jogador.retornaPersonagem(index);
    }


    public void removerJogadorPorIndice(Integer index) {
        this.listaDeJogadores.remove(index.intValue());
    }

    public void editarJogador(Integer index, String nome) {
        Jogador jogadorBusca = listaDeJogadores.get(index);
        jogadorBusca.setNomeJogador(nome);
    }

    public void listarJogador() {
        if (listaDeJogadores.size() == 0) {
            System.out.println("Lista vazia");
        }
        for (int i = 0; i < listaDeJogadores.size(); i++) {
            System.out.println("ID JOGADOR=" + i + "\n" + listaDeJogadores.get(i));
        }
    }

    public void listarPersonagens(int index) {
        if (listaDeJogadores.size() > index) {
            this.listaDeJogadores.get(index).listarPersonagens();
        }
    }

    @Override
    public void imprimir() {
        ClassePersonagem mago = new ClassePersonagem(1, 150, 40, 50, "Mago");
        ClassePersonagem elfo = new ClassePersonagem(2, 150, 50, 50, "Elfo");
        ClassePersonagem guerreiro = new ClassePersonagem(3, 150, 50, 40, "Guerreiro");
        System.out.println(mago);
        System.out.println(elfo);
        System.out.println(guerreiro);
    }
}




