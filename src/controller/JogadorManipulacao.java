package controller;

import java.util.ArrayList;

import entities.personagem.ClassePersonagem;
import entities.personagem.Jogador;
import entities.personagem.Personagem;
import interfaces.Impressao;

import java.util.List;


public class JogadorManipulacao implements Impressao {

    private List<Jogador> listaDeJogadores;
    private ClassePersonagem classePersonagem = new ClassePersonagem();

    public List<Jogador> getListaDeJogadores() {
        return listaDeJogadores;
    }

    public void setListaDeJogadores(List<Jogador> listaDeJogadores) {
        this.listaDeJogadores = listaDeJogadores;
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

    public ClassePersonagem addClasse(int tipo) {
        if (tipo == 1) {
            classePersonagem.setTipoNome("Mago");
            classePersonagem.setTipo(1);
            classePersonagem.setAtaqueClasse(40);
            classePersonagem.setVidaClasse(150);
            classePersonagem.setDefesaClasse(50);
            return this.classePersonagem;

        } else if (tipo == 2) {
            classePersonagem.setTipoNome("Elfo");
            classePersonagem.setTipo(2);
            classePersonagem.setAtaqueClasse(50);
            classePersonagem.setVidaClasse(150);
            classePersonagem.setDefesaClasse(50);
            return this.classePersonagem;
        } else if (tipo == 3) {
            classePersonagem.setTipoNome("Guerreiro");
            classePersonagem.setTipo(3);
            classePersonagem.setAtaqueClasse(50);
            classePersonagem.setVidaClasse(150);
            classePersonagem.setDefesaClasse(40);
            return this.classePersonagem;
        } else {
            System.out.println("O tipo selecionado é inválido!");
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




