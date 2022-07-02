package service;

import entities.Jogador;
import entities.Personagem;
import exceptions.BancoDeDadosException;
import repository.PersonagemRepository;

import java.util.Objects;

public class PersonagemService {

    PersonagemRepository personagemRepository = new PersonagemRepository();

    public void adicionar(Jogador jogador, Personagem personagem) throws BancoDeDadosException {
        personagemRepository.adicionar(personagem, jogador.getId());
    }

    public void editar(Personagem personagem,String nome) throws BancoDeDadosException {
        personagem.setNomePersonagem(nome);
        personagemRepository.editar(personagem.getId(),personagem);
    }

    public void listar() throws BancoDeDadosException {
        personagemRepository.listar();
    }

    public void remover(Personagem personagem) throws BancoDeDadosException {
        personagemRepository.remover(personagem.getId());
    }

    public Personagem retornaPersonagem(String nome) throws BancoDeDadosException {
        return personagemRepository.listar().stream().filter(a -> Objects.equals(a.getNomePersonagem(), nome)).map(a -> {
            return new Personagem(a.getId(),a.getNomePersonagem());
        }).findFirst().get();

    }
}
