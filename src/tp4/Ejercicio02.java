package tp4;

import DDR_backracking.Elemento;
import DDR_backracking.Mochila;

import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio02 {


    public static void main(String[] args) {
        ArrayList<Elemento> elementos = new ArrayList<>();

        elementos.add(new Elemento(18,25));
        elementos.add(new Elemento(15, 24));
        elementos.add(new Elemento(10, 15));

        Mochila m = new Mochila(20, elementos.size());

        Collections.sort(elementos);
        Collections.reverse(elementos);
        mochFracOptima(m, elementos);
        System.out.println(m.toString());
    }

    public static void mochFracOptima(Mochila m, ArrayList<Elemento> elementos) {
        int index = 0;
        while (m.getPesoMaximo() > m.getPeso() && index < elementos.size()) {
            if (m.pesoDisponible() > elementos.get(index).getPeso()) {
                m.addElemento(elementos.get(index));
            } else {
//                float sobrante = m.pesoDisponible();
//                Elemento aux = new Elemento(sobrante, elementos.get(index).getValorPorPeso() * (sobrante));
                m.addElemento(new Elemento(m.pesoDisponible(), elementos.get(index).getValorPorPeso() * m.pesoDisponible()));
            }
            index++;
        }
    }
}
