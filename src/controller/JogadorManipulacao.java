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
        this.listaDeJogadores.add(jogador);
    }

    public void addPersonagem(Personagem personagem){
        listaPersonagem.add(personagem);
    }

    public Jogador retornarJogador(int index) {
        return listaDeJogadores.get(index);
    }

    public ClassePersonagem addClasse(int tipo,Personagem personagem){
        if(tipo == 1){
            classePersonagem.setTipoNome("Mago");
            classePersonagem.setTipo(1);
            classePersonagem.setAtaqueClasse(40);
            classePersonagem.setVidaClasse(150);
            classePersonagem.setDefesaClasse(50);
            personagem.setClassePersonagem(classePersonagem);
            return this.classePersonagem;

        }else if(tipo == 2){
            classePersonagem.setTipoNome("Elfo");
            classePersonagem.setTipo(2);
            classePersonagem.setAtaqueClasse(50);
            classePersonagem.setVidaClasse(150);
            classePersonagem.setDefesaClasse(50);
            personagem.setClassePersonagem(classePersonagem);
            return this.classePersonagem;
        }else if(tipo == 3){
            classePersonagem.setTipoNome("Guerreiro");
            classePersonagem.setTipo(3);
            classePersonagem.setAtaqueClasse(50);
            classePersonagem.setVidaClasse(150);
            classePersonagem.setDefesaClasse(40);
            personagem.setClassePersonagem(classePersonagem);
            return this.classePersonagem;
        } else {
            System.out.println("O tipo selecionado é inválido!");
        }
        return null;
    }

    public void imprimirClasse() {
        ClassePersonagem mago = new ClassePersonagem(1, 150, 40, 50, "Mago");
        ClassePersonagem elfo = new ClassePersonagem(2, 150, 50, 50 , "Elfo");
        ClassePersonagem guerreiro = new ClassePersonagem(3, 150, 50, 40, "Guerreiro");
        System.out.println(mago);
        System.out.println(elfo);
        System.out.println(guerreiro);
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
            System.out.println("ID JOGADOR=" + i + " | " + listaDeJogadores.get(i));
        }
    }

    public void listarPersonagens() {
        for (int i = 0; i < listaPersonagem.size(); i++) {
            System.out.println("id=" + i + " | " + listaPersonagem.get(i));
        }
    }
}




