package service;

import entities.Jogador;
import entities.Personagem;
import exceptions.BancoDeDadosException;
import repository.PersonagemRepository;

import java.util.Objects;

public class PersonagemService {

    PersonagemRepository personagemRepository = new PersonagemRepository();

    public void adicionar(Jogador jogador, Personagem personagem) throws BancoDeDadosException {
        if(this.verificaNomePersonagem(personagem)) {
            personagemRepository.adicionar(personagem, jogador.getId());
        }
    }

    public void editar(Personagem personagem,String nome) throws BancoDeDadosException {
        personagem.setNomePersonagem(nome);
        if(this.verificaNomePersonagem(personagem)){
            personagemRepository.editar(personagem.getId(),personagem);
        }
    }

    public void listar() throws BancoDeDadosException {
        for (Personagem personagem : personagemRepository.listar()){
            System.out.println(personagem);
        }
    }

    public void remover(Personagem personagem) throws BancoDeDadosException {
        personagemRepository.remover(personagem.getId());
    }

    public Personagem retornaPersonagem(String nome) throws BancoDeDadosException {
        return personagemRepository.listar().stream().filter(a -> Objects.equals(a.getNomePersonagem(), nome)).map(a -> {
            return new Personagem(a.getId(),a.getNomePersonagem());
        }).findFirst().orElse(null);
    }
    public boolean verificaNomePersonagem(Personagem personagem) throws BancoDeDadosException {
        Personagem personagem1 = this.retornaPersonagem(personagem.getNomePersonagem());
        if (personagem1 == null) {
            return true;
        } else {
            return false;
        }
    }
}
