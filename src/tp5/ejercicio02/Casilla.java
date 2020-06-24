package tp5.ejercicio02;

import java.util.ArrayList;
import java.util.Arrays;

public class Casilla {

    private int[] cuadrante = new int[2];

    private boolean norte;

    private boolean este;

    private boolean sur;

    private boolean oeste;

    private boolean visitada;

    public Casilla(int fila, int columna, boolean norte, boolean este, boolean sur, boolean oeste) {
        this.cuadrante[0] = fila;
        this.cuadrante[1] = columna;
        this.norte = norte;
        this.este = este;
        this.sur = sur;
        this.oeste = oeste;
        this.visitada = false;
    }

    public int[] getCuadrante() {
        return cuadrante;
    }

    public boolean isNorte() {
        return norte;
    }

    public boolean isEste() {
        return este;
    }

    public boolean isSur() {
        return sur;
    }

    public boolean isOeste() {
        return oeste;
    }

    public boolean isVisitada() {
        return visitada;
    }

    public void setVisitada(boolean visitada) {
        this.visitada = visitada;
    }

    public ArrayList<int[]> getContiguas() {
        ArrayList<int[]> aux = new ArrayList<>();
        if (this.isNorte()) {
            int[] norte = {this.cuadrante[0]-1, this.cuadrante[1]};
            aux.add(norte);
        }
        if (this.isEste()) {
            int[] este = {this.cuadrante[0], this.cuadrante[1]+1};
            aux.add(este);
        }
        if (this.isSur()) {
            int[] sur = {this.cuadrante[0]+1, this.cuadrante[1]};
            aux.add(sur);
        }
        if (this.isOeste()) {
            int[] oeste = {this.cuadrante[0], this.cuadrante[1]-1};
            aux.add(oeste);
        }
        return aux;
    }

    @Override
    public String toString() {
        return "Casilla{" +
                "cuadrante=" + Arrays.toString(cuadrante) +
                '}';
    }
}
