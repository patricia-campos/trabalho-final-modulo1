package service;

import entities.ClassePersonagem;
import entities.Personagem;
import exceptions.BancoDeDadosException;
import repository.ClassePersonagemRepository;



public class ClassePersonagemService {

    ClassePersonagemRepository classePersonagemRepository = new ClassePersonagemRepository();

    public void adicionarClassePersonagem(Personagem personagem, ClassePersonagem classePersonagem) throws BancoDeDadosException {
        classePersonagemRepository.adicionar(classePersonagem, personagem.getId());
    }

    public void listarTodos() throws BancoDeDadosException {
        for (ClassePersonagem classe : classePersonagemRepository.listar()) {
            System.out.println(classe);
        }
    }

    public void remover(ClassePersonagem classePersonagem) throws BancoDeDadosException {
        classePersonagemRepository.remover(classePersonagem.getIdClassePersonagem());
    }

    public void editar(ClassePersonagem classePersonagem) throws BancoDeDadosException {
        classePersonagemRepository.editar(classePersonagem.getIdClassePersonagem(),classePersonagem);
    }

//    public ClassePersonagem retornaClasse(Personagem personagem, String nome) throws BancoDeDadosException {
//        return classePersonagemRepository.listar().stream().filter(c -> c.getIdPersonagem() == personagem.getId()).map( cp -> {
//            return new ClassePersonagem()
//                }
//        );
//    }

}


//    public Personagem retornaPersonagem(String nome) throws BancoDeDadosException {
//        return personagemRepository.listar().stream().filter(a -> Objects.equals(a.getNomePersonagem(), nome)).map(a -> {
//            return new Personagem(a.getId(),a.getNomePersonagem());
//        }).findFirst().get();
//
//    }

//    public void editar(Personagem personagem,String nome) throws BancoDeDadosException {
//        personagem.setNomePersonagem(nome);
//        personagemRepository.editar(personagem.getId(),personagem);
//    }

