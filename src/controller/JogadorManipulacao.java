package controller;

import java.util.ArrayList;

import entities.personagem.ClassePersonagem;
import entities.personagem.Jogador;
import entities.personagem.Personagem;

import java.util.List;


public class JogadorManipulacao {

    private List<Jogador> listaDeJogadores;
    private List<Personagem> listaPersonagem = new ArrayList<>();
    private ClassePersonagem classePersonagem = new ClassePersonagem();

    public Personagem retornaPersonagem(int index){
        if(this.listaPersonagem.size() == 0){
            return null;
        }
        return listaPersonagem.get(index);
    }

    public List<Jogador> getListaDeJogadores() {
        return listaDeJogadores;
    }

    public void setListaDeJogadores(List<Jogador> listaDeJogadores) {
        this.listaDeJogadores = listaDeJogadores;
    }

    public List<Personagem> getListaPersonagem() {
        return listaPersonagem;
    }

    public void setListaPersonagem(List<Personagem> listaPersonagem) {
        this.listaPersonagem = listaPersonagem;
    }

    public ClassePersonagem getClassePersonagem() {
        return classePersonagem;
    }

    public void setClassePersonagem(ClassePersonagem classePersonagem) {
        this.classePersonagem = classePersonagem;
    }

    public JogadorManipulacao() {
        this.listaDeJogadores = new ArrayList<>();
    }

    public void adicionarJogador(Jogador jogador) {
        System.out.println(this.retornaPersonagem(0));
        this.listaDeJogadores.add(jogador);
    }

    public void addPersonagem(Personagem personagem){
        listaPersonagem.add(personagem);
    }

    public ClassePersonagem addClasse(int tipo,Personagem personagem){
        if(tipo == 1){
            classePersonagem.setTipo(1);
            classePersonagem.setAtaqueJogador(50);
            classePersonagem.setVidaJogador(100);
            classePersonagem.setDefesaJogador(50);
            personagem.setClassePersonagem(classePersonagem);
            return this.classePersonagem;

        }else if(tipo == 2){
            classePersonagem.setTipo(2);
            classePersonagem.setAtaqueJogador(50);
            classePersonagem.setVidaJogador(100);
            classePersonagem.setDefesaJogador(50);
            personagem.setClassePersonagem(classePersonagem);
            return this.classePersonagem;
        }else if(tipo == 3){
            classePersonagem.setTipo(3);
            classePersonagem.setAtaqueJogador(50);
            classePersonagem.setVidaJogador(100);
            classePersonagem.setDefesaJogador(50);
            personagem.setClassePersonagem(classePersonagem);
            return this.classePersonagem;
        } else {
            System.out.println("Tipo invalido");
        }
        return null;
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




