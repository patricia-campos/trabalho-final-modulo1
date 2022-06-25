package entities;

public class Boss {

    private String nome;
    private int vida;
    private int ataque;
    private int defesa;
    private Cenario reino;

    public Boss() {
    }

    public Boss(String nome, int vida, int ataque, int defesa, Cenario reino) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.reino = reino;
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

    public Cenario getReino() {
        return reino;
    }

    public void setReino(Cenario reino) {
        this.reino = reino;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "nome='" + nome + '\'' +
                ", vida=" + vida +
                ", ataque=" + ataque +
                ", defesa=" + defesa +
                ", reino=" + reino +
                '}';
    }
}
