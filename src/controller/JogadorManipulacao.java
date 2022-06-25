package controller;

import java.util.ArrayList;
import entities.personagem.Jogador;
import java.util.List;


public class JogadorManipulacao {

        private List<Jogador> listaDeJogadores;

        public JogadorManipulacao() {
            this.listaDeJogadores = new ArrayList<>();
        }

        public void adicionarJogador(Jogador jogador) {
            this.listaDeJogadores.add(jogador);
        }

       // remover por nome
        public void removerJogadorPorNome(String nomeJogador) {
            boolean contemNaLista = this.listaDeJogadores.contains(nomeJogador);
            if (contemNaLista == true) {
                this.listaDeJogadores.remove(nomeJogador);
            } else {
                System.out.println("Esse jogador não existe na lista.");
            }
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




