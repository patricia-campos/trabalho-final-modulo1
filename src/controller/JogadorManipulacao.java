package controller;

import java.util.ArrayList;

import entities.personagem.ClassePersonagem;
import entities.personagem.Jogador;
import entities.personagem.Personagem;

import java.util.List;


public class JogadorManipulacao {

    private List<Jogador> listaDeJogadores;
    private List<Personagem> listaPersonagem;
    private ClassePersonagem classePersonagem;

    public Personagem retornaPersonagem(int index){
        return this.listaDeJogadores.get(index).getPersonagem();
    }

    public JogadorManipulacao() {
        this.listaDeJogadores = new ArrayList<>();
    }

    public void adicionarJogador(Jogador jogador) {
        System.out.println(jogador.getPersonagem());
        this.listaDeJogadores.add(jogador);
    }

    public void addPersonagem(Personagem personagem){
        listaPersonagem.add(personagem);
    }

    public void addClasse(int tipo){
        if(tipo == 1){
            classe.setTipo(1);
            classe.setAtaqueJogador(50);

            classe.setVidaJogador(100);
            classe.setDefesaJogador(50);
            personagem.setClassePersonagem(classe);

        }else if(tipo == 2){
            classe.setTipo(2);
            classe.setAtaqueJogador(50);
            classe.setVidaJogador(100);
            classe.setDefesaJogador(50);
            personagem.setClassePersonagem(classe);

        }else if(tipo == 3){
            classe.setTipo(3);
            classe.setAtaqueJogador(50);
            classe.setVidaJogador(100);
            classe.setDefesaJogador(50);
            personagem.setClassePersonagem(classe);
        } else {
            System.out.println();
        }
    }


    public void removerJogadorPorIndice(Integer index) {
        this.listaDeJogadores.remove(index.intValue());
    }

    public void editarJogador(Integer index, String nome) {
        Jogador jogadorBusca = listaDeJogadores.get(index);
        jogadorBusca.setNomeJogador(nome);
    }

    public void listarPessoas() {
        for (int i = 0; i < listaDeJogadores.size(); i++) {
            System.out.println("id=" + i + " | " + listaDeJogadores.get(i));
        }
    }
}




