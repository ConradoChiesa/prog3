package tp5.ejercicio02;

import java.util.ArrayList;
import java.util.Iterator;

public class Laberinto {

    private Casilla[][] casillas;

    private ArrayList<Casilla> longitudMinima;

    public Laberinto(int fila, int columna) {
        this.casillas = new Casilla[fila][columna];
        this.longitudMinima = new ArrayList<>();
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public Casilla getCasilla(int[] pos) {
        return this.casillas[pos[0]][pos[1]];
    }

    public void setCasilla(int fila, int columna, boolean norte, boolean este, boolean sur, boolean oeste) {
        this.casillas[fila][columna] = new Casilla(fila, columna, norte, este, sur, oeste);
    }

    public ArrayList<Casilla> longitudMinima(int[] inicio, int[] fin) {
        ArrayList<Casilla> menorActual = new ArrayList<>();
        menorActual.add(getCasilla(inicio));
        getCasilla(inicio).setVisitada(true);
        longitudMinima(inicio, fin, menorActual);
        return longitudMinima;
    }

    private void longitudMinima(int[] inicio, int[] fin, ArrayList<Casilla> menorActual) {

        if (inicio[0] == fin[0] && inicio[1] == fin[1]) {
            if (menorActual.size() < longitudMinima.size() || longitudMinima.isEmpty()) {
                longitudMinima.clear();
                longitudMinima.addAll(menorActual);
            }
            System.out.println(menorActual);
        } else {
//            ArrayList<int[]> casillasContiguas = new ArrayList<>();
            Iterator<int[]> it = casillas[inicio[0]][inicio[1]].getContiguas().iterator();
            while (it.hasNext()) {
                int[] nextInicio = it.next();
                if (!getCasilla(nextInicio).isVisitada()) {
                    menorActual.add(getCasilla(nextInicio));
                    casillas[nextInicio[0]][nextInicio[1]].setVisitada(true);
                    longitudMinima(nextInicio, fin, menorActual);
                    casillas[nextInicio[0]][nextInicio[1]].setVisitada(false);
                    menorActual.remove(menorActual.size()-1);
                }
            }
        }
    }


}
