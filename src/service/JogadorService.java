package service;

import entities.Jogador;
import exceptions.BancoDeDadosException;
import repository.JogadorRepository;

import java.util.Objects;

public class JogadorService {
    JogadorRepository jogadorRepository = new JogadorRepository();

    public void adicionar(Jogador jogador) throws BancoDeDadosException {
        if (jogador == null) {
            System.out.println("Jogador não encontrado");
        } else {
            if (this.verificaNomeJogador(jogador)) {
                jogadorRepository.adicionar(jogador);
            } else {
                System.out.println("Jogador ja cadastrado");
            }
        }
    }

    public void listarTodos() throws BancoDeDadosException {
        for (Jogador jogador1 : jogadorRepository.listar()) {
            System.out.println(jogador1);
        }
    }

    public void remover(Jogador jogador) throws BancoDeDadosException {
        if (jogador == null) {
            System.out.println("Jogador não encontrado");
        } else {
            jogadorRepository.remover(jogador.getId());
        }
    }

    public void editar(Jogador jogador, String nome) throws BancoDeDadosException {
        if (jogador == null) {
            System.out.println("Jogador não encontrado");
        } else {
            jogador.setNomeJogador(nome);
            if (this.verificaNomeJogador(jogador)) {
                jogadorRepository.editar(jogador.getId(), jogador);
            } else {
                System.out.println("Não possivel editar nome ja existente");
            }
        }
    }

    public Jogador retornaJogador(String nome) throws BancoDeDadosException {
        Jogador jogador = jogadorRepository.listar().stream().filter(a -> Objects.equals(a.getNomeJogador(), nome)).map(a -> {
            return new Jogador(a.getId(), a.getNomeJogador(), a.getSenha());
        }).findFirst().orElse(null);
        if(jogador == null){
            System.out.println("Jogador Vazio");
            return null;
        }
        return jogador;
    }

    //Verifica se existe um jogador com o nome na minha base de dados, caso exista ele traz o objeto com valor e retorna false nao podendo alterar.
    public boolean verificaNomeJogador(Jogador jogador) throws BancoDeDadosException {
        if (jogador == null) {
            System.out.println("Jogador não encontrado");
        } else {
            Jogador jogador1 = this.retornaJogador(jogador.getNomeJogador());
            if (jogador1 == null) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
