package view;

import entities.Jogador;
import entities.Personagem;
import exceptions.BancoDeDadosException;
import service.ClassePersonagemService;
import service.JogadorService;
import service.PersonagemService;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) throws BancoDeDadosException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nome do jogador");
        String nomeJogador = sc.nextLine();

        JogadorService jogadorService = new JogadorService();
        Jogador jogador = new Jogador(nomeJogador, "Senha123");
        jogadorService.adicionar(jogador);
        jogadorService.listarTodos();
        jogadorService.editar(jogadorService.retornaJogador("Luanito"),"Luiz");
//        jogadorService.listarTodos();

//        jogadorService.remover(jogador);
//        PersonagemService personagemService = new PersonagemService();
//        Personagem personagem = new Personagem("Legolas");
//
//        personagemService.adicionar(jogadorService.retornaJogador("Joãozito"),personagem);
//        personagemService.listar();
//        personagemService.editar(personagemService.retornaPersonagem("Legolas"),"Eric");
//        personagemService.listar();
//        personagemService.remover(personagemService.retornaPersonagem("Joao"));
//
//        ClassePersonagemService classePersonagemService = new ClassePersonagemService();
//        ClassePersonagem classePersonagem = new ClassePersonagem("Mago", 150, 50, 50);
//        classePersonagemService.adicionarClassePersonagem(personagemService.retornaPersonagem("Legolas") ,classePersonagem);

    }
}
