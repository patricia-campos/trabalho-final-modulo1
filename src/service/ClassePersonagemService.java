package service;

import entities.ClassePersonagem;
import entities.Jogador;
import entities.Personagem;
import exceptions.BancoDeDadosException;
import repository.ClassePersonagemRepository;

import java.util.Objects;


public class ClassePersonagemService {

    ClassePersonagemRepository classePersonagemRepository = new ClassePersonagemRepository();

    public void adicionarClassePersonagem(Personagem personagem, ClassePersonagem classePersonagem) throws BancoDeDadosException {
        if(personagem == null){
            System.out.println("Personagem inexistente");
        }else if(classePersonagem == null){
            System.out.println("Classe inexistente");
        }else{
            classePersonagemRepository.adicionar(classePersonagem, personagem.getId());
        }
    }

    public void listarTodos() throws BancoDeDadosException {
        for (ClassePersonagem classe : classePersonagemRepository.listar()) {
            System.out.println(classe);
        }
    }

    public void remover(ClassePersonagem classePersonagem) throws BancoDeDadosException {
        if(classePersonagem == null){
            System.out.println("Classe inexistente");
        }else {
            classePersonagemRepository.remover(classePersonagem.getIdClassePersonagem());
        }
    }

    public void editar(ClassePersonagem classePersonagem) throws BancoDeDadosException {
        if(classePersonagem == null){
            System.out.println("Classe inexistente");
        }else{
            classePersonagemRepository.editar(classePersonagem.getIdClassePersonagem(), classePersonagem);
        }
    }

    public ClassePersonagem retornaClasse(String nome) throws BancoDeDadosException {
        return classePersonagemRepository.listar().stream().filter(a -> Objects.equals(a.getNomeClassePersonagem(), nome)).map(a -> {
            return new ClassePersonagem(a.getIdClassePersonagem(), a.getNomeClassePersonagem(), a.getVidaClasse(), a.getDefesaClasse(), a.getAtaqueClasse());
        }).findFirst().orElse(null);
    }
    
}

