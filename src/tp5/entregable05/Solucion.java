package tp5.entregable05;

import java.util.ArrayList;

public class Solucion {
    private ArrayList<DiaDeVisita> diasDeVisita;

    private int bono;

    private int estadosVisitados;

    public Solucion(ArrayList<DiaDeVisita> diasDeVisita, int bono, int estadosVisitados) {
        this.diasDeVisita = new ArrayList<>();
        this.diasDeVisita.addAll(diasDeVisita);
        this.bono = bono;
        this.estadosVisitados = estadosVisitados;
    }

    public ArrayList<DiaDeVisita> getDiasDeVisita() {
        return diasDeVisita;
    }

    public int getBono() {
        return bono;
    }

    public int getEstadosVisitados() {
        return estadosVisitados;
    }

}
