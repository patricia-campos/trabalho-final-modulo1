package service;

import entities.Jogador;
import entities.Personagem;
import exceptions.BancoDeDadosException;
import repository.JogadorRepository;

import java.util.List;

public class JogadorService {
    JogadorRepository jogadorRepository = new JogadorRepository();

    public void adicionar(Jogador jogador) throws BancoDeDadosException {
        jogadorRepository.adicionar(jogador);
    }

    public void listarTodos() throws BancoDeDadosException {
        for (Jogador jogador1 : jogadorRepository.listar()) {
            System.out.println(jogador1);
        }
    }

    public void remover(Jogador jogador) throws BancoDeDadosException {
        jogadorRepository.remover(jogador.getId());
    }

    public void editar(Jogador jogador) throws BancoDeDadosException {
        jogadorRepository.editar(jogador.getId(),jogador);
    }

}
