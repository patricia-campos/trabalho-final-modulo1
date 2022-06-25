package controller;

import entities.personagem.ClassePersonagem;
import entities.personagem.Personagem;

import java.util.ArrayList;
import java.util.List;

public class PersonagemManipulacao {

    private Personagem personagem;
    private ClassePersonagemManipulacao classePersonagem = new ClassePersonagemManipulacao();


    public void adicionarPersonagem(String nome, int clasePersonagem) {
        this.personagem.setNomePersonagem(nome);
        classePersonagem.adicionarClasse(clasePersonagem, this.personagem);
    }

    public void removerPersonagemPorIndice(Personagem personagem) {
        personagem = new Personagem();
    }

    public void editarPersonagem(Personagem personagem, String nomeNovo) {
        personagem.setNomePersonagem(nomeNovo);
    }

    public void listarPersonagens() {
        System.out.println(this.personagem);
    }

    public void removerClassePersonagem() {
        this.classePersonagem = null;
    }

    @Override
    public String toString() {
        return "PersonagemManipulacao{" +
                "personagens=" + personagem +
                ", classePersonagem=" + classePersonagem +
                '}';
    }
}

