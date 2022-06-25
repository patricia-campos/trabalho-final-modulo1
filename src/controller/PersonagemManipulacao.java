package controller;

import entities.Personagem;

import java.util.ArrayList;
import java.util.List;

public class PersonagemManipulacao {

        private List<Personagem> listaDePersonagens;

        public PersonagemManipulacao() {
            this.listaDePersonagens = new ArrayList<>();
        }

        public void adicionarPersonagem(Personagem personagem) {
            this.listaDePersonagens.add(personagem);
        }

        public void removerPersonagemPorIndice(Integer index) {
            this.listaDePersonagens.remove(index.intValue());
        }

        public void editarPersonagem(Integer index, Personagem personagem) {
            Personagem personagemBusca = listaDePersonagens.get(index);
            personagemBusca.setJogador(personagem.getJogador());
            personagemBusca.setNomePersonagem(personagem.getNomePersonagem());
            personagemBusca.setClassePersonagem(personagem.getClassePersonagem());
        }

        public void listarPersonagens() {
            for (int i = 0; i < listaDePersonagens.size(); i++) {
                System.out.println("id=" + i + " | " + listaDePersonagens.get(i));
            }
        }
    }

