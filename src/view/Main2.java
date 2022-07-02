package view;

import entities.Jogador;
import entities.Personagem;
import exceptions.BancoDeDadosException;
import service.JogadorService;
import service.PersonagemService;

public class Main2 {

    public static void main(String[] args) throws BancoDeDadosException {
        JogadorService jogadorService = new JogadorService();
//        Jogador jogador = new Jogador("Joãozito", "Senha123");
//        jogadorService.adicionar(jogador);
//        jogadorService.listarTodos();
//        jogadorService.editar(jogadorService.retornaJogador("Joãozito"),"Luiz");
//        jogadorService.listarTodos();

//        jogadorService.remover(jogador);
        PersonagemService personagemService = new PersonagemService();
        Personagem personagem = new Personagem("Legolas");

        personagemService.adicionar(jogadorService.retornaJogador("Joãozito"),personagem);
        personagemService.listar();
        personagemService.editar(personagemService.retornaPersonagem("Legolas"),"Eric");
        personagemService.listar();
        personagemService.remover(personagemService.retornaPersonagem("Joao"));


    }
}
