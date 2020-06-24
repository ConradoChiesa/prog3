package tp4.entregable04;

import java.util.ArrayList;

public class Solucion {

    private ArrayList<DiaDeVisita> diasDeVisita;

    private int bono;

    public Solucion(ArrayList<DiaDeVisita> diasDeVisita, int bono) {
        this.diasDeVisita = diasDeVisita;
        this.bono = bono;
    }

    public ArrayList<DiaDeVisita> getDiasDeVisita() {
        return diasDeVisita;
    }

    public int getBono() {
        return bono;
    }
}
