package controller;

import java.util.ArrayList;
import entities.Jogador;
import java.util.List;


public class JogadorManipulacao {

        private List<Jogador> listaDeJogadores;

        public JogadorManipulacao() {
            this.listaDeJogadores = new ArrayList<>();
        }

        public void adicionarJogador(Jogador jogador) {
            this.listaDeJogadores.add(jogador);
        }

        public void removerJogadorPorIndice(Integer index) {
            this.listaDeJogadores.remove(index.intValue());
        }

        public void editarJogador(Integer index, Jogador jogador) {
            Jogador jogadorBusca = listaDeJogadores.get(index);
            jogadorBusca.setNomeJogador(jogador.getNomeJogador());
            jogadorBusca.setPersonagem(jogador.getPersonagem());
        }

        public void listarPessoas() {
            for (int i = 0; i < listaDeJogadores.size(); i++) {
                System.out.println("id=" + i + " | " + listaDeJogadores.get(i));
            }
        }
    }




