package service;

import entities.Jogador;
import exceptions.BancoDeDadosException;
import repository.JogadorRepository;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public void editar(Jogador jogador,String nome) throws BancoDeDadosException {
        jogador.setNomeJogador(nome);
        jogadorRepository.editar(jogador.getId(),jogador);
    }

    public Jogador retornaJogador(String nome) throws BancoDeDadosException {
        return jogadorRepository.listar().stream().filter(a -> Objects.equals(a.getNomeJogador(), nome)).map(a -> {
            return new Jogador(a.getId(),a.getNomeJogador(),a.getSenha());
        }).findFirst().get();

    }
}
