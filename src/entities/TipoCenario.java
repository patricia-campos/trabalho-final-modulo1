package entities;

import java.util.Arrays;

public enum TipoCenario {

    SOMBRIO(1),
    LUZ(2);

    private Integer tipo;

    TipoCenario(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public static TipoCenario ofTipo(Integer tipo) { // 1
        return Arrays.stream(TipoCenario.values()) //[SOMBRIO(1) , LUZ(2)]
                .filter(tp -> tp.getTipo().equals(tipo)) //[SOMBRIO(1)]
                .findFirst() //optional => SOMBRIO(1)
                .get();//SOMBRIO(1)
    }
}
