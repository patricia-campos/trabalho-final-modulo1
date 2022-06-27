package view;

import controller.Batalha;
import controller.JogadorManipulacao;
import entities.personagem.Jogador;
import entities.personagem.Personagem;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
                                         \\  /                                                  \\  /
                                          \\/                                                    \\/
                                    
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


            System.out.print("\n");
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
                case 1 -> {
                    System.out.println("Olá jogador! Digite seu nome: ");
                    String nomeJogador = sc.nextLine();
                    if (Objects.equals(nomeJogador, "")) {
                        System.out.println("Nome não pode ser vazio.");
                        break;
                    }
                    System.out.println(nomeJogador + ", agora você deve criar seu personagem: ");
                    System.out.println("Digite o nome do personagem: ");
                    String nome = sc.nextLine();
                    if (Objects.equals(nome, "")) {
                        System.out.println("Nome não pode ser vazio.");
                        break;
                    }
                    System.out.println("Escolha sua classe: 1 - Mago | 2 - Elfo | 3 - Guerreira");
                    jogadorManipulacao.imprimir();
                    int escolhaClasse = sc.nextInt();
                    sc.nextLine();
                    if (escolhaClasse > 3 || escolhaClasse <= 0) {
                        System.out.println("Tipo inválido.");
                        break;
                    }
                    Personagem personagemInicial = new Personagem(nome, escolhaClasse);
                    Jogador jogador = new Jogador(nomeJogador, personagemInicial);
                    personagemInicial.setNomePersonagem(nome);
                    jogadorManipulacao.addPersonagem(jogador, personagemInicial);
                    jogadorManipulacao.adicionarJogador(jogador);

                }
                case 2 -> {
                    System.out.println("Digite 1 para ver jogadores cadastrados");
                    System.out.println("Digite 2 para ver personagens cadastrados");
                    System.out.println("Digite 3 para sair");
                    opcaoImprimir = sc.nextInt();
                    switch (opcaoImprimir) {
                        case 1 -> {
                            if (jogadorManipulacao.getListaDeJogadores().size() == 0) {
                                System.out.println("Lista vazia");
                                break;
                            }
                            jogadorManipulacao.listarJogador();
                        }
                        case 2 -> {
                            System.out.println("Qual o seu Jogador");
                            jogadorManipulacao.listarJogador();
                            int indexJogador = sc.nextInt();
                            if (jogadorManipulacao.getListaDeJogadores().size() == 0) {
                                System.out.println("Lista vazia");
                            } else if (jogadorManipulacao.retornarJogador(indexJogador) == null) {
                                System.out.println("Jogador não encontrado");
                            } else {
                                Jogador jogador = jogadorManipulacao.retornarJogador(indexJogador);
                                jogador.listarPersonagens(jogador);
                            }
                        }
                    }
                }
                case 3 -> {
                    if (jogadorManipulacao.getListaDeJogadores().size() == 0) {
                        System.out.println("Jogadores vazios.");
                        break;
                    }
                    System.out.println("Qual jogador você quer alterar o nome?");
                    jogadorManipulacao.listarJogador();
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (!(jogadorManipulacao.getListaDeJogadores().size() > index)) {
                        System.out.println("Jogador nao existe!! ");
                        break;
                    }
                    System.out.println("Digite o novo nome do jogador: ");
                    String novoNome = sc.nextLine();
                    if (Objects.equals(novoNome, "")) {
                        System.out.println("Nome não pode ser vazio.");
                        break;
                    }
                    jogadorManipulacao.editarJogador(index, novoNome);
                }
                case 4 -> {
                    if (jogadorManipulacao.getListaDeJogadores().size() == 0) {
                        System.out.println("Jogadores vazios");
                        break;
                    }
                    System.out.println("Qual jogador você deseja remover?");
                    jogadorManipulacao.listarJogador();
                    int id = sc.nextInt();
                    if (!(jogadorManipulacao.getListaDeJogadores().size() > id)) {
                        System.out.println("Jogador nao existe!! ");
                        break;
                    }
                    jogadorManipulacao.removerJogadorPorIndice(id);
                }
                case 5 -> {
                    System.out.println("Em qual jogador você deseja adicionar um personagem?");
                    jogadorManipulacao.listarJogador();
                    int id = sc.nextInt();
                    sc.nextLine();
                    Jogador jogadorParaAddPersonagem = jogadorManipulacao.retornarJogador(id);

                    System.out.println(jogadorParaAddPersonagem.getNomeJogador() + ", agora você deve criar seu personagem: ");
                    System.out.println("Digite o nome do personagem: ");
                    String nome = sc.nextLine();
                    if (Objects.equals(nome, "")) {
                        System.out.println("Nome não pode ser vazio.");
                        break;
                    }
                    System.out.println("Escolha sua classe: 1 - Mago | 2 - Elfo | 3 - Guerreira");
                    jogadorManipulacao.imprimir();
                    int escolhaClasse = sc.nextInt();
                    sc.nextLine();
                    if (escolhaClasse > 3 || escolhaClasse <= 0) {
                        System.out.println("Tipo inválido.");
                        break;
                    }
                    Personagem novoPersonagem = new Personagem(nome, escolhaClasse);
                    jogadorParaAddPersonagem.setPersonagem(novoPersonagem);
                    System.out.println(jogadorManipulacao.getListaDeJogadores().get(0).getPersonagem().get(0));
                    System.out.println(jogadorManipulacao.getListaDeJogadores().get(0).getPersonagem().get(1));
                }
                case 6 -> {
                    Batalha batalha = new Batalha();
                    if (jogadorManipulacao.getListaDeJogadores().size() == 0) {
                        System.out.println("Jogadores vazios");
                        break;
                    }

                    System.out.println("Selecione seu jogador digitando seu ID:");
                    jogadorManipulacao.listarJogador();
                    int localJogador = sc.nextInt();
                    sc.nextLine();
                    if (!(jogadorManipulacao.getListaDeJogadores().size() > localJogador)) {
                        System.out.println("Jogador nao existe!! ");
                        break;
                    }
                    Jogador jogadorDoJogo = jogadorManipulacao.retornarJogador(localJogador);
                    System.out.println("Selecione seu personagem digitando seu ID: ");
                    jogadorManipulacao.listarPersonagens(localJogador, jogadorDoJogo);
                    int indexPersonagem = sc.nextInt();
                    Personagem personagem = jogadorManipulacao.retornaPersonagem(jogadorDoJogo, indexPersonagem);
                    if (!(jogadorDoJogo.getPersonagem().size() > indexPersonagem)) {
                        System.out.println("Personagem nao existe ");
                        break;
                    }
                    batalha.setPersonagem(personagem);
                    sc.nextLine();
                    batalha.setPersonagem(jogadorManipulacao.retornaPersonagem(jogadorDoJogo, indexPersonagem));

                    comecar = 0;
                    while (comecar != 3) {

                        System.out.println("Digite 1 para começar a batalha: ");
                        System.out.println("Digite 2 para começar round: " + i);
                        System.out.println("Digite 3 para fugir da batalha:");
                        comecar = sc.nextInt();
                        sc.nextLine();
                        switch (comecar) {
                            case 1 -> {
                                if (!Objects.isNull(batalha.getCenario())) {
                                    System.out.println("Batalha já foi iniciada");
                                    break;
                                }
                                batalha.sortearCenario();
                                batalha.retornaBoss();
                                System.out.println("Batalha iniciada");
                                System.out.println("Cenario sorteado\n" + batalha.getCenario());
                            }
                            case 2 -> {
                                if (Objects.isNull(batalha.getCenario())) {
                                    System.out.println("Você precisa começar a batalha");
                                } else if (batalha.getBoss().getVida() <= 0) {
                                    i = 1;
                                    vitoria = true;
                                    batalha.setBoss(null);
                                    batalha.setCenario(null);
                                    batalha.retornaStatusVitoria(vitoria);
                                    comecar = 3;
                                } else if (batalha.getPersonagem().getClassePersonagem().getVidaClasse() <= 0) {
                                    i = 1;
                                    vitoria = false;
                                    batalha.setBoss(null);
                                    batalha.setCenario(null);
                                    batalha.retornaStatusVitoria(vitoria);
                                    comecar = 3;
                                } else {
                                    batalha.inciarRound();
                                    batalha.setRoundAtual(i);
                                    i++;
                                }
                            }
                            case 3 -> {
                                System.out.println("você fugiu da batalha");
                                batalha.setBoss(null);
                                batalha.setCenario(null);
                            }
                        }
                    }
                }
                case 7 -> System.out.println("Você saiu do jogo");
            }
        }
    }
}

