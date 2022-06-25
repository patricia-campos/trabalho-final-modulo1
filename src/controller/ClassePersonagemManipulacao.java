package controller;

import entities.personagem.ClassePersonagem;

import java.util.ArrayList;
import java.util.List;

public class ClassePersonagemManipulacao {

        private List<ClassePersonagem> listaDeClasses;

        public ClassePersonagemManipulacao() {
            this.listaDeClasses = new ArrayList<>();
        }

        public void adicionarClasse(ClassePersonagem classePersonagem) {this.listaDeClasses.add(classePersonagem);}

        public void removerClassePorIndice(Integer index) {this.listaDeClasses.remove(index.intValue());}

        public void editarClasse(Integer index, ClassePersonagem classePersonagem) {
            ClassePersonagem classeBusca = listaDeClasses.get(index);
            classeBusca.setTipo(classeBusca.getTipo());
            classeBusca.setVidaJogador(classeBusca.getVidaJogador());
            classeBusca.setDefesaJogador(classeBusca.getDefesaJogador());
            classeBusca.setAtaqueJogador(classeBusca.getAtaqueJogador());
        }

        public void listarPersonagens() {
            for (int i = 0; i < listaDeClasses.size(); i++) {
                System.out.println("id=" + i + " | " + listaDeClasses.get(i));
            }
        }
    }

