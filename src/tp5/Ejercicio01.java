package tp5;

import tp3.Arco;
import tp3.GrafoDirigido;
import tp3.Vertice;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio01 {
private static ArrayList<Integer> solucionMayor = new ArrayList<>();
//    private GrafoDirigido ConjuntoSalas;
    // Ls int son los valores en el vertice por ende el número de sala
    public static void maximaCantidadSalas(GrafoDirigido conjuntoSalas, ArrayList<Integer> solucionActual, int salaActual, int salida) {
        
        if (salaActual == salida) {
//            solucionActual.add(salaActual);
            if (solucionMayor.size() < solucionActual.size()) {
                solucionMayor.clear();
                solucionMayor.addAll(solucionActual);
                System.out.println(solucionMayor);
            }
//            solucionActual.remove(solucionActual.size()-1);
        } else {
//            solucionActual.add(salaActual);
            Iterator<Arco> puertasSalaActual = conjuntoSalas.obtenerArcos(salaActual);
            while (puertasSalaActual.hasNext()) {
//                solucionActual.add(salaActual);
                Arco puerta = puertasSalaActual.next();
                solucionActual.add(puerta.getVerticeDestino());
                maximaCantidadSalas(conjuntoSalas, solucionActual, puerta.getVerticeDestino(), salida);
                solucionActual.remove(solucionActual.size()-1);
            }
//            solucionActual.remove(solucionActual.size()-1);
        }
    }

    public static void main(String[] args) {
        GrafoDirigido conjuntoSalas = new GrafoDirigido();
        ArrayList<Integer> solucionActual = new ArrayList<>();
        conjuntoSalas.agregarVertice(0);
        conjuntoSalas.agregarVertice(1);
        conjuntoSalas.agregarVertice(2);
        conjuntoSalas.agregarVertice(3);
        conjuntoSalas.agregarVertice(4);
        conjuntoSalas.agregarVertice(5);
        conjuntoSalas.agregarVertice(6);
        conjuntoSalas.agregarVertice(7);
        conjuntoSalas.agregarVertice(8);
        conjuntoSalas.agregarVertice(9);
        conjuntoSalas.agregarVertice(10);
        conjuntoSalas.agregarVertice(11);
        conjuntoSalas.agregarVertice(12);

        conjuntoSalas.agregarArco(0, 1, 0);
        conjuntoSalas.agregarArco(0, 2, 0);
        conjuntoSalas.agregarArco(1, 3, 0);
        conjuntoSalas.agregarArco(2, 5, 0);
        conjuntoSalas.agregarArco(2, 7, 0);
        conjuntoSalas.agregarArco(3, 4, 0);
        conjuntoSalas.agregarArco(3, 6, 0);
        conjuntoSalas.agregarArco(4, 11, 0);
        conjuntoSalas.agregarArco(5, 6, 0);
        conjuntoSalas.agregarArco(6, 10, 0);
        conjuntoSalas.agregarArco(6, 12, 0);
        conjuntoSalas.agregarArco(7, 8, 0);
        conjuntoSalas.agregarArco(8, 9, 0);
        conjuntoSalas.agregarArco(9, 10, 0);
        conjuntoSalas.agregarArco(11, 12, 0);

        maximaCantidadSalas(conjuntoSalas, solucionActual, 0, 10);
    }
}
