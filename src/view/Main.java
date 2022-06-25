package view;

import controller.ClassePersonagemManipulacao;
import controller.JogadorManipulacao;
import controller.PersonagemManipulacao;
import entities.personagem.ClassePersonagem;
import entities.personagem.Jogador;
import entities.personagem.Personagem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(".   ║\\.\n" +
                           "    ║▒\\.\n" +
                           "    ║▒▒\\\n" +
                           "    ║░▒║\n" +
                           "    ║░▒║\n" +
                           "    ║░▒║\n" +
                           "    ║░▒║\n" +
                           "    ║░▒║\n" +
                           "    ║░▒║\n" +
                           "    ║░▒║\n" +
                           "    ║░▒║\n" +
                           "    ║░▒║\n" +
                           "  ▓▓▓▓▓▓▓\n" +
                           "    ]█▓[\n" +
                           "    ]█▓[\n" +
                           "    ]█▓[");

        System.out.println("BEM VINDO AO JOGO xxxx!");

        JogadorManipulacao jogadorManipulacao = new JogadorManipulacao();
        PersonagemManipulacao personagemManipulacao = new PersonagemManipulacao();
        ClassePersonagemManipulacao classePersonagemManipulacao = new ClassePersonagemManipulacao();

        int opcao = 0;
        int opcaoPersonagem = 0;

        while (opcao != 9) {
            System.out.println("Digite 1 para cadastrar um novo jogador");
            System.out.println("Digite 2 para ver os jogadores cadastrados");
            System.out.println("Digite 3 para editar um jogador");
            System.out.println("Digite 4 para excluír um jogador");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 :
                    Jogador jogador = new Jogador();
                    System.out.println("Olá jogador, digite seu nome: ");
                    jogador.setNomeJogador(sc.nextLine());

                    System.out.println("Agora você deve criar seu personagem: ");
                    Personagem personagem = new Personagem();


                    System.out.println("Digite o nome do personagem: ");
                    personagem.setNomePersonagem(sc.nextLine());
                    //ImprimirClassesPersonagens


                    System.out.println("Escolha sua classe: 1 - Mago / 2 - Elfo / 3 - Guerreira");
                    opcaoPersonagem= sc.nextInt();

                    switch (opcaoPersonagem) {
                        case 1 -> {
                            personagem.setClassePersonagem(new ClassePersonagem(1, 100, 50, 100));
                            personagemManipulacao.adicionarPersonagem(personagem);
                        }
                        case 2 -> {
                            personagem.setClassePersonagem(new ClassePersonagem(2, 100, 60, 80));
                            personagemManipulacao.adicionarPersonagem(personagem);
                        }
                        case 3 -> {
                            personagem.setClassePersonagem(new ClassePersonagem(3, 100, 70, 90));
                            personagemManipulacao.adicionarPersonagem(personagem);
                        }
                    }
                    jogadorManipulacao.adicionarJogador(jogador);
                    break;
                case 2:
               personagemManipulacao.listarPersonagens();
                    break;
                case 3:

            }
        }

    }
}
