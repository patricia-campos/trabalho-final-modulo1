package view;

import entities.Jogador;
import entities.Personagem;
import exceptions.BancoDeDadosException;
import repository.JogadorRepository;
import repository.PersonagemRepository;
import service.JogadorService;

public class Main2 {

    public static void main(String[] args) throws BancoDeDadosException {
        JogadorService jogadorService = new JogadorService();
        Jogador jogador = new Jogador("Joãozito", "Senha123");
        jogadorService.adicionar(jogador);
        jogadorService.listarTodos();
        Jogador jogadorEditado = new Jogador("Luanzito","Senha123");
        jogadorService.editar(jogadorEditado);
        jogadorService.listarTodos();

//        jogadorService.remover(jogador);

    }
}
