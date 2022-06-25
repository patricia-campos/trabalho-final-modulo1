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

                    PersonagemManipulacao personagem = new PersonagemManipulacao();
                    System.out.println("Digite o nome do personagem: ");
                    personagem.adicionarPersonagem(sc.nextLine());

                    System.out.println("Escolha sua classe: 1 - Mago / 2 - Elfo / 3 - Guerreira");

                    personagem.adicionarClassePersonagem(sc.nextInt());
                    sc.nextLine();
                    jogadorManipulacao.adicionarJogador(jogador);
                    break;

                case 2:
                    jogadorManipulacao.listarPessoas();
                    break;

                case 3:
                    System.out.println("Qual jogador você quer alterar o nome?");
                    jogadorManipulacao.listarPessoas();
                    int index = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o novo nome do jogador: ");
                    String novoNome = sc.nextLine();
                    jogadorManipulacao.editarJogador(index, novoNome);
                    break;

                case 4:
                    System.out.println("Qual jogador você deseja remover?");
                    jogadorManipulacao.listarPessoas();
                    int id =sc.nextInt();
                    jogadorManipulacao.removerJogadorPorIndice(id);
                    break;
            }
        }

    }
}
