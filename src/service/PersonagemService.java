package service;

import entities.Jogador;
import entities.Personagem;
import exceptions.BancoDeDadosException;
import repository.PersonagemRepository;

public class PersonagemService {

    PersonagemRepository personagemRepository = new PersonagemRepository();

    public void adicionar(Jogador jogador, Personagem personagem) throws BancoDeDadosException {
        personagemRepository.adicionar(personagem, jogador.getId());
    }

    public void editar(Personagem personagem) throws BancoDeDadosException {
        personagemRepository.editar(personagem.getId(),personagem);
    }

    public void listar() throws BancoDeDadosException {
        personagemRepository.listar();
    }

    public void remover(Personagem personagem) throws BancoDeDadosException {
        personagemRepository.remover(personagem.getId());
    }
}
