package view;

import controller.Batalha;
import controller.JogadorManipulacao;
import entities.personagem.ClassePersonagem;
import entities.personagem.Jogador;
import entities.personagem.Personagem;

import java.util.Objects;
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
        Jogador jogador;
        Personagem personagem = new Personagem();

        int opcao = 0;
        int opcaoImprimir;

        while (opcao != 9) {
            System.out.print("\n");
            System.out.println("Digite 1 para CADASTRAR um NOVO JOGADOR");
            System.out.println("Digite 2 para VER os JOGADORES CADASTRADOS");
            System.out.println("Digite 3 para EDITAR um JOGADOR");
            System.out.println("Digite 4 para EXCLUIR um JOGADOR");
            System.out.println("Digite 5 para INICIAR a batalha");
            opcao = sc.nextInt();
            sc.nextLine();


            switch (opcao) {
                case 1 :
                    System.out.println("Olá jogador! Digite seu nome: ");
                    jogador = new Jogador();
                    String nomeJogador = sc.nextLine();
                    if(Objects.equals(nomeJogador, "")){
                        System.out.println("Nome não pode ser vazio.");
                        break;
                    }

                    System.out.println(nomeJogador + ", agora você deve criar seu personagem: ");


                    System.out.println("Digite o nome do personagem: ");
                    String nome = sc.nextLine();
                    if(Objects.equals(nome, "")){
                        System.out.println("Nome não pode ser vazio.");
                        break;
                    }

                    System.out.println("Escolha sua classe: 1 - Mago | 2 - Elfo | 3 - Guerreira");
                    int escolhaClasse= sc.nextInt();
                    sc.nextLine();
                    if(escolhaClasse > 3 || escolhaClasse <=0){
                        System.out.println("Tipo inválido.");
                        break;
                    }

                    personagem.setClassePersonagem(jogadorManipulacao.addClasse(escolhaClasse,personagem));
                    jogador.setNomeJogador(nomeJogador);
                    personagem.setNomePersonagem(nome);
                    jogadorManipulacao.addPersonagem(personagem);
                    jogadorManipulacao.adicionarJogador(jogador);
                    System.out.println(personagem);
                    break;

                case 2:

                    System.out.println("Digite 1 para ver jogadores cadastrados");
                    System.out.println("Digite 2 para ver personagens cadastrados");
                    System.out.println("Digite 3 para sair");
                    opcaoImprimir = sc.nextInt();

                    switch (opcaoImprimir) {

                        case 1:
                            if(jogadorManipulacao.getListaDeJogadores().size() == 0){
                                System.out.println("Lista vazia");
                                break;
                            }
                            jogadorManipulacao.listarPessoas();
                            break;

                        case 2:
                            if(jogadorManipulacao.getListaPersonagem().size() == 0){
                                System.out.println("Lista vazia");
                                break;
                            } else {
                                jogadorManipulacao.listarPersonagens();
                                break;}

                    }

                case 3:
                    if(jogadorManipulacao.getListaDeJogadores().size() == 0){
                        System.out.println("Jogadores vazios.");
                        break;
                    }
                    System.out.println("Qual jogador você quer alterar o nome?");
                    jogadorManipulacao.listarPessoas();
                    int index = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o novo nome do jogador: ");
                    String novoNome = sc.nextLine();
                    jogadorManipulacao.editarJogador(index, novoNome);
                    break;

                case 4:
                    if(jogadorManipulacao.getListaDeJogadores().size() == 0){
                        System.out.println("Jogadores vazios");
                        break;
                    }
                    System.out.println("Qual jogador você deseja remover?");
                    jogadorManipulacao.listarPessoas();
                    int id =sc.nextInt();
                    jogadorManipulacao.removerJogadorPorIndice(id);
                    break;

                case 5:
                    Batalha batalha = new Batalha();
                    if(jogadorManipulacao.getListaDeJogadores().size() == 0){
                        System.out.println("Jogadores vazios");
                        break;
                    }
                    System.out.println("Escolha seu personagem: ");
                    batalha.setPersonagem(jogadorManipulacao.retornaPersonagem(sc.nextInt()));
                    batalha.sortearCenario();
                    batalha.inciarBatalha();
                    break;

            }
        }
    }
}
