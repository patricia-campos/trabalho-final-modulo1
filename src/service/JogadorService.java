package service;

import entities.Jogador;
import exceptions.BancoDeDadosException;
import repository.JogadorRepository;

import java.util.Objects;

public class JogadorService {
    JogadorRepository jogadorRepository = new JogadorRepository();

    public void adicionar(Jogador jogador) throws BancoDeDadosException {
        if (this.verificaNomeJogador(jogador)) {
            jogadorRepository.adicionar(jogador);
        } else {
            System.out.println("Jogador ja cadastrado");
        }
    }

    public void listarTodos() throws BancoDeDadosException {
        for (Jogador jogador1 : jogadorRepository.listar()) {
            System.out.println(jogador1);
        }
    }

    public void remover(Jogador jogador) throws BancoDeDadosException {
        jogadorRepository.remover(jogador.getId());
    }

    public void editar(Jogador jogador, String nome) throws BancoDeDadosException {
        jogador.setNomeJogador(nome);
        if (this.verificaNomeJogador(jogador)) {
            jogadorRepository.editar(jogador.getId(), jogador);
        } else {
            System.out.println("Não possivel editar nome ja existente");
        }
    }

    public Jogador retornaJogador(String nome) throws BancoDeDadosException {
        return jogadorRepository.listar().stream().filter(a -> Objects.equals(a.getNomeJogador(), nome)).map(a -> {
            return new Jogador(a.getId(), a.getNomeJogador(), a.getSenha());
        }).findFirst().orElse(null);
    }

    //Verifica se existe um jogador com o nome na minha base de dados, caso exista ele traz o objeto com valor e retona false nao podendo alterar.
    public boolean verificaNomeJogador(Jogador jogador) throws BancoDeDadosException {
        Jogador jogador1 = this.retornaJogador(jogador.getNomeJogador());
        if (jogador1 == null) {
            return true;
        } else {
            return false;
        }
    }
}
