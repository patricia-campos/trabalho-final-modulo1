package controller;

import entities.personagem.ClassePersonagem;
import entities.personagem.Personagem;

public class ClassePersonagemManipulacao {

        ClassePersonagem classe = new ClassePersonagem();

        public void adicionarClasse(int tipo, Personagem personagem) {
            if(tipo == 1){
                classe.setTipo(1);
                classe.setAtaqueJogador(50);
                classe.setVidaJogador(100);
                classe.setDefesaJogador(50);
                personagem.setClassePersonagem(classe);

            }else if(tipo == 2){
                classe.setTipo(2);
                classe.setAtaqueJogador(50);
                classe.setVidaJogador(100);
                classe.setDefesaJogador(50);
                personagem.setClassePersonagem(classe);

            }else if(tipo == 3){
                classe.setTipo(3);
                classe.setAtaqueJogador(50);
                classe.setVidaJogador(100);
                classe.setDefesaJogador(50);
                personagem.setClassePersonagem(classe);
            } else {
                System.out.println();
            }
        }

        public void listarPersonagens() {
            classe.imprimir();
            }
        }

