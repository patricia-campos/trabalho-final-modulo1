package entities;

import controller.Batalha;
import interfaces.Impressao;

import java.util.Date;

public class Cenario implements Impressao {

    private int idCenario;
    private String nomeCenario;
    private TipoCenario tipoCenario;
    private java.sql.Date horario;

    public TipoCenario getTipoCenario() {
        return tipoCenario;
    }

    public void setTipoCenario(TipoCenario tipoCenario) {
        this.tipoCenario = tipoCenario;
    }

    public int getIdCenario() {
        return idCenario;
    }

    public void setIdCenario(int idCenario) {
        this.idCenario = idCenario;
    }

    public String getNomeCenario() {
        return nomeCenario;
    }

    public void setNomeCenario(String nomeCenario) {
        this.nomeCenario = nomeCenario;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = (java.sql.Date) horario;
    }

    @Override
    public String toString() {
        return "Cenario{" +
                "idCenario=" + idCenario +
                ", nomeCenario='" + nomeCenario + '\'' +
                ", horario=" + horario +
                '}';
    }

    public void buffDebuff(Batalha batalha) {

    }

    @Override
    public void imprimir() {

    }
}
