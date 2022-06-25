package view;

import controller.PersonagemManipulacao;
import entities.personagem.Personagem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Crie seu personagem: ");
//
//        System.out.println("Digite o nome do personagem: ");
//        String nome = sc.nextLine();

        PersonagemManipulacao personagemManipulacao = new PersonagemManipulacao();

        int opcao = 0;

        while (opcao != 9) {
            System.out.println("Digite 1 para criar um novo personagem");
            System.out.println("Digite 2 para ver os personagens já criados");
            System.out.println("Digite 3 para editar um personagem");
            System.out.println("Digite 4 para excluír um personagem");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
//                    Personagem personagem = new Personagem();
//                    personagem.setClassePersonagem();
            }
        }




    }
}
