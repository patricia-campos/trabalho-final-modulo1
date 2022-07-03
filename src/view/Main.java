package view;

import banco.DbConfiguration;
import controller.Batalha;
import controller.JogadorManipulacao;
import entities.ClassePersonagem;
import entities.Jogador;
import entities.Personagem;
import exceptions.BancoDeDadosException;
import service.ClassePersonagemService;
import service.JogadorService;
import service.PersonagemService;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws BancoDeDadosException {
        Scanner sc = new Scanner(System.in);
        System.out.println("""

                                         __                                                     __
                                        (**)                                                   (**)
                                        IIII                                                   IIII
                                        ####                                                   ####
                                        HHHH           O Reino de Luz e o Reino Sombrio        HHHH
                                        HHHH          foram prejudicados com o desepertar      HHHH
                                        ####            de seres poderosos e com sede de       ####
                                     ___IIII___                     sangue.                 ___IIII___
                                  .-`_._"**"_._`-.                                       .-`_._"**"_._`-.
                                |/``  .`\\/`.  ``\\|          Há um desequilíbrio        |/``  .`\\/`.  ``\\|
                                       }    {     '             pairando sobre                }    {     '
                                       ) () (                 todas as criaturas              ) () (
                                       ( :: )               e só você pode ajudar             ( :: )
                                       | :: |              a reestabelecer a ordem            | :: |
                                       | )( |                entre o Reino da Luz             | )( |
                                       | || |                 e o Reino Sombrio.              | || |
                                       | || |                                                 | || |
                                       | || |                   Você está pronto              | || |
                                       | || |                     para iniciar                | || |
                                       | || |                     a batalha?                  | || |
                                       ( () )                                                 ( () )
                                        \\  /                                                   \\  /
                                         \\/                                                     \\/

                """);

        System.out.println("""

                ██████╗  █████╗ ████████╗████████╗██╗     ███████╗     ██████╗ ███████╗    ██╗    ██╗ ██████╗ ██████╗ ██╗     ██████╗ ███████╗
                ██╔══██╗██╔══██╗╚══██╔══╝╚══██╔══╝██║     ██╔════╝    ██╔═══██╗██╔════╝    ██║    ██║██╔═══██╗██╔══██╗██║     ██╔══██╗██╔════╝
                ██████╔╝███████║   ██║      ██║   ██║     █████╗      ██║   ██║█████╗      ██║ █╗ ██║██║   ██║██████╔╝██║     ██║  ██║███████╗
                ██╔══██╗██╔══██║   ██║      ██║   ██║     ██╔══╝      ██║   ██║██╔══╝      ██║███╗██║██║   ██║██╔══██╗██║     ██║  ██║╚════██║
                ██████╔╝██║  ██║   ██║      ██║   ███████╗███████╗    ╚██████╔╝██║         ╚███╔███╔╝╚██████╔╝██║  ██║███████╗██████╔╝███████║""");

        JogadorManipulacao jogadorManipulacao = new JogadorManipulacao();

        boolean vitoria;
        int opcao = 0;
        int opcaoImprimir;
        int comecar;
        int i = 1;

        while (opcao != 7) {
            DbConfiguration db = new DbConfiguration();
            JogadorService jogadorService = new JogadorService();
            PersonagemService personagemService = new PersonagemService();
            ClassePersonagemService classePersonagemService = new ClassePersonagemService();

            System.out.print("\n");
            System.out.println("Digite 0 para cadastrar automaticamente");
            System.out.println("Digite 1 para CADASTRAR um NOVO JOGADOR");
            System.out.println("Digite 2 para VER os JOGADORES CADASTRADOS");
            System.out.println("Digite 3 para EDITAR um JOGADOR");
            System.out.println("Digite 4 para EXCLUIR um JOGADOR");
            System.out.println("Digite 5 para ADICIONAR um PERSONAGEM");
            System.out.println("Digite 6 para INICIAR a BATALHA");
            System.out.println("Digite 7 para SAIR do JOGO");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 0 -> {
//                    String nomeJogador = "Gustavo";
//                    String nomePersonagem = "Legolas";
//                    Personagem personagemInicial = new Personagem(nomePersonagem, escolhaClasse);
//                    Jogador jogador = new Jogador(nomeJogador, personagemInicial);
//                    personagemInicial.setNomePersonagem(nomePersonagem);
//                    jogadorManipulacao.addPersonagem(jogador, personagemInicial);
//                    jogadorManipulacao.adicionarJogador(jogador);
                }
                case 1 -> {
                    System.out.println("Olá jogador! Digite seu nome: ");
                    String nomeJogador = sc.nextLine();
                    if (Objects.equals(nomeJogador, "")) {
                        System.out.println("Nome não pode ser vazio.");
                        break;
                    }

                    System.out.println(nomeJogador + " digite sua senha: ");
                    String senhaJogador = sc.nextLine();

                    Jogador jogador = new Jogador(nomeJogador, senhaJogador);
                    jogadorService.adicionar(jogador);

                    System.out.println(nomeJogador + ", agora você deve criar seu personagem: ");

                    System.out.println("Digite o nome do personagem: ");
                    String nomePersonagem = sc.nextLine();
                    if (Objects.equals(nomePersonagem, "")) {
                        System.out.println("Nome não pode ser vazio.");
                        break;
                    }

                    Personagem personagem = new Personagem(nomePersonagem);
                    personagemService.adicionar(jogadorService.retornaJogador(nomeJogador), personagem);

                    System.out.println("Escolha sua classe: Mago | Elfo | Guerreiro");
                    String classeNome = sc.nextLine();
                    int vida = 150;
                    int defesa = 40;
                    int ataque = 50;
                    if (classeNome == "Mago") {
                        vida = 150;
                        defesa = 40;
                        ataque = 50;
                    } else if (classeNome == "Elfo") {
                        vida = 150;
                        defesa = 50;
                        ataque = 50;
                    } else if (classeNome == "Guerreiro") {
                        vida = 150;
                        defesa = 50;
                        ataque = 40;
                    }
                    ClassePersonagem classePersonagem = new ClassePersonagem(classeNome, vida, defesa, ataque);
                    classePersonagemService.adicionarClassePersonagem(personagemService.retornaPersonagem(nomePersonagem), classePersonagem);
                }
                case 2 -> {
                    System.out.println("Digite 1 para ver jogadores cadastrados");
                    System.out.println("Digite 2 para ver personagens cadastrados");
                    System.out.println("Digite 3 para ver classes cadastradas");
                    opcaoImprimir = sc.nextInt();
                    switch (opcaoImprimir) {
                        case 1 -> {
                            jogadorService.listarTodos();
                            break;
                        }
                        case 2 -> {
                            personagemService.listar();
                            break;
                        }
                        case 3 -> {
                            classePersonagemService.listarTodos();
                            break;
                        }
                        case default -> System.out.println("Numero incorreto");
                    }
                }
                case 3 -> {
                    System.out.println("Digite 1 para alterar nome do Jogador");
                    System.out.println("Digite 2 alterar nome do Personagem");
                    System.out.println("Digite 3 para ver classes cadastradas");
                    opcao = sc.nextInt();
                    sc.nextLine();
                    switch (opcao) {
                        case 1 -> {
                            System.out.println("Qual jogador deseja alterar o nome? ");
                            jogadorService.listarTodos();
                            String nome = sc.nextLine();
                            Jogador jogador1 = jogadorService.retornaJogador(nome);
                            System.out.println("Digite o novo nome do Jogador: ");
                            String novoNome = sc.nextLine();
                            jogadorService.editar(jogador1, novoNome);

                        }
                        case 2 -> {
                            System.out.println("Qual personagem deseja alterar o nome? ");
                            personagemService.listar();
                            String nome = sc.nextLine();
                            Personagem personagem = personagemService.retornaPersonagem(nome);
                            System.out.println("Digite o novo nome do Personagem: ");
                            String novoNome = sc.nextLine();
                            personagemService.editar(personagem, novoNome);
                        }
                        default -> {
                            System.out.println("opcão inválida");
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Digite 1 para remover Jogador");
                    System.out.println("Digite 2 para remover Personagem");
                    System.out.println("Digite 3 para ver classes cadastradas");
                    opcao = sc.nextInt();
                    sc.nextLine();
                    switch (opcao) {
                        case 1 -> {
                            System.out.println("Qual jogador deseja remover? ");
                            jogadorService.listarTodos();
                            String nome = sc.nextLine();
                            jogadorService.remover(jogadorService.retornaJogador(nome));
                        }
                        case 2 -> {
                            System.out.println("Qual personagem deseja remover? ");
                            personagemService.listar();
                            String nome = sc.nextLine();
                            personagemService.remover(personagemService.retornaPersonagem(nome));
                        }
                        case 3 -> {
                            System.out.println("Qual Classe deseja remover? ");
                            classePersonagemService.listarTodos();
                            String nome = sc.nextLine();
                            classePersonagemService.remover(classePersonagemService.retornaClasse(nome));
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Em qual jogador você deseja adicionar um personagem?");
                    jogadorService.listarTodos();
                    String nome = sc.nextLine();

                    Jogador jogador = jogadorService.retornaJogador(nome);

                    System.out.println(jogador.getNomeJogador() + ", agora você deve criar seu personagem: ");
                    System.out.println("Digite o nome do personagem: ");
                    String nomePersonagem = sc.nextLine();
                    if (Objects.equals(nome, "")) {
                        System.out.println("Nome não pode ser vazio.");
                        break;
                    }

                    Personagem personagem = new Personagem(nomePersonagem);
                    personagemService.adicionar(jogadorService.retornaJogador(nome), personagem);

                    System.out.println("Escolha sua classe: Mago | Elfo | Guerreiro");
                    String classeNome = sc.nextLine();
                    int vida = 150;
                    int defesa = 40;
                    int ataque = 50;
                    if (classeNome == "Mago") {
                        vida = 150;
                        defesa = 40;
                        ataque = 50;
                    } else if (classeNome == "Elfo") {
                        vida = 150;
                        defesa = 50;
                        ataque = 50;
                    } else if (classeNome == "Guerreiro") {
                        vida = 150;
                        defesa = 50;
                        ataque = 40;
                    }
                    ClassePersonagem classePersonagem = new ClassePersonagem(classeNome, vida, defesa, ataque);
                    classePersonagemService.adicionarClassePersonagem(personagemService.retornaPersonagem(nomePersonagem), classePersonagem);
                }
            }
//
        }
//                case 6 -> {
//                    Batalha batalha = new Batalha();
//                    if (jogadorManipulacao.getListaDeJogadores().size() == 0) {
//                        System.out.println("Jogadores vazios");
//                        break;
//                    }
//
//                    System.out.println("Selecione seu jogador digitando seu ID:");
//                    jogadorManipulacao.listarJogador();
//                    int localJogador = sc.nextInt();
//                    sc.nextLine();
//                    if (!(jogadorManipulacao.getListaDeJogadores().size() > localJogador)) {
//                        System.out.println("Jogador nao existe!! ");
//                        break;
//                    }
//                    Jogador jogadorDoJogo = jogadorManipulacao.retornarJogador(localJogador);
//                    System.out.println("Selecione seu personagem digitando seu ID: ");
//                    jogadorManipulacao.listarPersonagens(localJogador, jogadorDoJogo);
//                    int indexPersonagem = sc.nextInt();
//                    sc.nextLine();
//                    Personagem personagem = jogadorManipulacao.retornaPersonagem(jogadorDoJogo, indexPersonagem);
//                    if (!(jogadorDoJogo.getPersonagem().size() > indexPersonagem)) {
//                        System.out.println("Personagem nao existe ");
//                        break;
//                    }
//                    batalha.setPersonagem(personagem);
//                    comecar = 0;
//                    while (comecar != 3) {
//
//                        System.out.println("Digite 1 para começar a batalha: ");
//                        System.out.println("Digite 2 para atacar: ");
//                        System.out.println("Digite 3 para fugir da batalha:");
//                        comecar = sc.nextInt();
//                        sc.nextLine();
//                        switch (comecar) {
//                            case 1 -> {
//                                if (!Objects.isNull(batalha.getCenario())) {
//                                    System.out.println("Batalha já foi iniciada");
//                                    break;
//                                }
//                                batalha.sortearCenario();
//                                batalha.retornaBoss();
//                                System.out.println("Batalha iniciada");
//                                System.out.println("Cenario sorteado\n" + batalha.getCenario());
//                            }
//                            case 2 -> {
//                                if (Objects.isNull(batalha.getCenario())) {
//                                    System.out.println("Você precisa começar a batalha");
//                                } else if (batalha.getBoss().getVida() <= 0) {
//                                    i = 1;
//                                    vitoria = true;
//                                    batalha.setBoss(null);
//                                    batalha.setCenario(null);
//                                    batalha.retornaStatusVitoria(vitoria);
//                                    comecar = 3;
//                                } else if (batalha.getPersonagem().getClassePersonagem().getVidaClasse() <= 0) {
//                                    i = 1;
//                                    vitoria = false;
//                                    batalha.setBoss(null);
//                                    batalha.setCenario(null);
//                                    batalha.retornaStatusVitoria(vitoria);
//                                    comecar = 3;
//                                } else {
//                                    System.out.println("\nRound: " + i + "\n");
//                                    batalha.inciarRound();
//                                    batalha.setRoundAtual(i);
//                                    i++;
//                                }
//                            }
//                            case 3 -> {
//                                System.out.println("Você fugiu da batalha");
//                                batalha.setBoss(null);
//                                batalha.setCenario(null);
//                            }
//                            case default -> System.out.println("Numero incorreto");
//                        }
//                    }
//                }
//        case 7 -> System.out.println("Você saiu do jogo");
//        case default -> System.out.println("Numero incorreto");
    }
}



