package view;

import controller.BatalhaController;
import entities.ClassePersonagem;
import entities.Jogador;
import entities.Personagem;
import exceptions.BancoDeDadosException;
import service.BatalhaService;
import service.ClassePersonagemService;
import service.JogadorService;
import service.PersonagemService;

import java.util.Locale;
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
                                       | || |                     a batalhaController?        | || |
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


        boolean vitoria;
        int opcao = 0;
        int opcaoImprimir;
        int comecar;
        int i = 1;

        while (opcao != 7) {
            JogadorService jogadorService = new JogadorService();
            PersonagemService personagemService = new PersonagemService();
            ClassePersonagemService classePersonagemService = new ClassePersonagemService();
            BatalhaService batalhaService = new BatalhaService();

            System.out.print("\n");
            System.out.println("Digite 0 para cadastrar automaticamente");
            System.out.println("Digite 1 para CADASTRAR um NOVO JOGADOR");
            System.out.println("Digite 2 para VER os JOGADORES CADASTRADOS");
            System.out.println("Digite 3 para EDITAR um JOGADOR");
            System.out.println("Digite 4 para EXCLUIR um JOGADOR");
            System.out.println("Digite 5 para ADICIONAR um PERSONAGEM");
            System.out.println("Digite 6 para INICIAR a BATALHA");
            System.out.println("Digite 7 para SAIR do JOGO");

            //While até pessoa digitar opção do menu
            while (!sc.hasNextInt()) {
                System.out.println("Opção inválida. Digite um número conforme menu.");
                sc.nextLine();
            }

            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 0 -> {
                    Personagem personagemInicial = new Personagem("Legolas");
                    Jogador jogador = new Jogador("Gustavo", "senha");
                    ClassePersonagem classePersonagem = new ClassePersonagem("Mago");
                    classePersonagemService.adicionarClassePersonagem(personagemInicial,classePersonagem);
                    personagemService.adicionar(jogador, personagemInicial);
                    jogadorService.adicionar(jogador);
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
                    String classeNome = sc.nextLine().toUpperCase();
                    ClassePersonagem classePersonagem = new ClassePersonagem(classeNome);
                    classePersonagemService.adicionarClassePersonagem(personagemService.retornaPersonagem(nomePersonagem), classePersonagem);
                }
                case 2 -> {
                    System.out.println("Digite 1 para ver jogadores cadastrados");
                    System.out.println("Digite 2 para ver personagens cadastrados");
                    System.out.println("Digite 3 para ver classes cadastradas");

                    //While até pessoa digitar opção do menu
                    while (!sc.hasNextInt()) {
                        System.out.println("Opção inválida. Digite um número conforme menu.");
                        sc.nextLine();
                    }

                    opcaoImprimir = sc.nextInt();
                    sc.nextLine();
                    switch (opcaoImprimir) {
                        case 1 -> jogadorService.listarTodos();
                        case 2 -> {
                            System.out.println("Qual o nome do seu Jogador? ");
                            String nomeJogador = sc.nextLine().toUpperCase();
                            Jogador jogadorParaListar = jogadorService.retornaJogador(nomeJogador);
                            if (jogadorParaListar == null) {
                                System.out.println("Jogador não encontrado");
                                break;
                            }
                            personagemService.listarPersonagemsPorJogador(jogadorParaListar.getId());
                        }
                        case 3 -> {
                            System.out.println("Digite o nome do seu personagem: ");
                            String nomePersonagem = sc.nextLine();
                            Personagem personagem =personagemService.retornaPersonagem(nomePersonagem);
                            if(personagem == null){
                                System.out.println("Personagem nao encontrado");
                                break;
                            }

                            classePersonagemService.retornaClasseDoPersonagem(personagem);
                        }
                        case default -> System.out.println("Numero incorreto");
                    }
                }
                case 3 -> {
                    System.out.println("Digite 1 para alterar nome do Jogador");
                    System.out.println("Digite 2 alterar nome do Personagem");
                    System.out.println("Digite 3 para ver classes cadastradas");

                    //While até pessoa digitar opção do menu
                    while (!sc.hasNextInt()) {
                        System.out.println("Opção inválida. Digite um número conforme menu.");
                        sc.nextLine();
                    }

                    opcao = sc.nextInt();
                    sc.nextLine();
                    switch (opcao) {
                        case 1 -> {
                            System.out.println("Qual jogador deseja alterar o nome? ");
                            jogadorService.listarTodos();
                            String nome = sc.nextLine();
                            System.out.println("Digite o novo nome do Jogador: ");
                            String novoNome = sc.nextLine();
                            Jogador jogador1 = jogadorService.retornaJogador(nome);
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
                        default -> System.out.println("opcão inválida");
                    }
                }
                case 4 -> {
                    System.out.println("Digite 1 para remover Jogador");
                    System.out.println("Digite 2 para remover Personagem");
                    System.out.println("Digite 3 para ver classes cadastradas");

                    //While até pessoa digitar opção do menu
                    while (!sc.hasNextInt()) {
                        System.out.println("Opção inválida. Digite um número conforme menu.");
                        sc.nextLine();
                    }

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

                    System.out.println("Escolha sua classe: Mago | Elfo | Guerreiro");
                    String classeNome = sc.nextLine();
                    if (!Objects.equals(classeNome, "MAGO") &&!Objects.equals(classeNome, "ELFO") &&!Objects.equals(classeNome, "GUERREIRO") ){
                        System.out.println("Classe invalida");
                        break;
                    }
                    Personagem personagem = new Personagem(nomePersonagem);
                    personagemService.adicionar(jogadorService.retornaJogador(nome), personagem);
                    ClassePersonagem classePersonagem = new ClassePersonagem(classeNome);
                    classePersonagemService.adicionarClassePersonagem(personagemService.retornaPersonagem(nomePersonagem), classePersonagem);
                }
                case 6 -> {
                    BatalhaController batalhaController = new BatalhaController();
                    System.out.println("Selecione seu jogador digitando seu username:");
                    jogadorService.listarTodos();
                    String localJogador = sc.nextLine().toUpperCase(Locale.ROOT);

                    Jogador jogadorDoJogo = jogadorService.retornaJogador(localJogador);
                    System.out.println("Selecione seu personagem digitando seu nome: ");
                    personagemService.listarPersonagemsPorJogador(jogadorDoJogo.getId());

                    String nomePersonagem = sc.nextLine();

                    Personagem personagem = personagemService.retornaPersonagem(nomePersonagem);
                    if (personagem == null) {
                        break;
                    }
                    batalhaController.setPersonagem(personagem);
                    batalhaController.getPersonagem().setClassePersonagem(classePersonagemService.retornaClassePorPersonagem(personagem));
                    comecar = 0;
                    while (comecar != 3) {

                        System.out.println("Digite 1 para começar a batalha: ");
                        System.out.println("Digite 2 para atacar: ");
                        System.out.println("Digite 3 para fugir da batalha:");

                        //While até pessoa digitar opção do menu
                        while (!sc.hasNextInt()) {
                            System.out.println("Opção inválida. Digite um número conforme menu.");
                            sc.nextLine();
                        }

                        comecar = sc.nextInt();
                        sc.nextLine();
                        switch (comecar) {
                            case 1 -> {
                                if (!Objects.isNull(batalhaController.getCenario())) {
                                    System.out.println("Batalha já foi iniciada");
                                    break;
                                }
                                batalhaController.sortearCenario();
                                batalhaController.retornaBoss();
                                System.out.println("Batalha iniciada");
                                System.out.println("Cenario sorteado\n" + batalhaController.getCenario());
                            }
                            case 2 -> {
                                if (Objects.isNull(batalhaController.getCenario())) {
                                    System.out.println("Você precisa começar a batalha");
                                } else if (batalhaController.getBoss().getVida() <= 0) {
                                    i = 1;
                                    vitoria = true;
                                    batalhaController.retornaStatusVitoria(vitoria);
                                    batalhaService.adicionar(batalhaController.retornaBatalha(jogadorDoJogo.getId(),"Vitoria",batalhaController.getCenario()));
                                    batalhaController.setBoss(null);
                                    batalhaController.setCenario(null);
                                    comecar = 3;
                                } else if (batalhaController.getPersonagem().getClassePersonagem().getVidaClasse() <= 0) {
                                    i = 1;
                                    vitoria = false;
                                    batalhaController.retornaStatusVitoria(vitoria);
                                    batalhaService.adicionar(batalhaController.retornaBatalha(jogadorDoJogo.getId(),"Derrota", batalhaController.getCenario()));
                                    batalhaController.setBoss(null);
                                    batalhaController.setCenario(null);
                                    comecar = 3;
                                } else {
                                    System.out.println("\nRound: " + i + "\n");
                                    batalhaController.inciarAtaque();
                                    batalhaController.setRoundAtual(i);
                                    i++;
                                }
                            }
                            case 3 -> {
                                System.out.println("Você fugiu da batalhaController");
                                batalhaController.setBoss(null);
                                batalhaController.setCenario(null);
                            }
                            case default -> System.out.println("Numero incorreto");
                        }
                    }
                }
                case 7 -> System.out.println("Você saiu do jogo");
                case default -> System.out.println("Numero incorreto");
            }
        }
    }
}

