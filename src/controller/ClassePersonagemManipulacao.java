package controller;

import entities.personagem.ClassePersonagem;
import entities.personagem.Personagem;

import java.util.ArrayList;
import java.util.List;

public class ClassePersonagemManipulacao {

        ClassePersonagem classe;


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
            }
        }

        public void listarPersonagens() {
            classe.imprimir();
            }
        }

