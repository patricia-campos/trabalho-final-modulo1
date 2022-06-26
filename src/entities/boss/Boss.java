package entities.boss;

import entities.cenario.Cenario;

public class Boss {

    private String nome;
    private int vida;
    private int ataque;
    private int defesa;

    public Boss() {
    }

    public Boss(String nome) {
        this.nome = nome;
        this.vida = 100;
        this.ataque = 20;
        this.defesa = 15;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }


    @Override
    public String toString() {
        return "Boss{" +
                "nome='" + nome + '\'' +
                ", vida=" + vida +
                ", ataque=" + ataque +
                ", defesa=" + defesa +
                '}';
    }
}
