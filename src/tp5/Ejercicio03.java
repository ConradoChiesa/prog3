package tp5;

import java.util.ArrayList;
import java.util.Iterator;

/*
* Suma de subconjuntos. Dados n números positivos distintos, se desea encontrar todas las
* combinaciones de esos números tal que la suma sea igual a M.
*
* */
public class Ejercicio03 {
    public static int N = 50;
    public static int M = 15;
        private ArrayList<Integer> soluciones = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Integer> numerosPositivos = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numerosPositivos.add((int)Math.random()*1000+1);
        }
        for (int i = 0; i < numerosPositivos.size(); i++) {
            combinarTalQueDe(M, i, 0);

        }

        /*Iterator it = numerosPositivos.iterator();
        while (it.hasNext()) {

        }*/

    }

    private static void combinarTalQueDe(int m, int posActual, int sumaActual) {
//    private static void combinarTalQueDe(int m, int posActual, int sumaActual, ArrayList) {
        // tomo el primero, me fijo si es menor a M, lo comienzo a sumar con el resto
        // del arreglo
        // si el primero es menor a
        if (sumaActual == m) {

        } else {
            
            combinarTalQueDe(m, posActual+1, sumaActual);

        }
    }
}
