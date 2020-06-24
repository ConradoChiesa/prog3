package tp5.ejercicio02;

import java.util.ArrayList;
/*
*
* El laberinto esta diagramado en el siguiente link:
* https://docs.google.com/spreadsheets/d/1Gm-yP9pfglzl6NvTomJPV81jVM7tk2fEnNtzIKKIYVQ/edit?usp=sharing
*
*/
public class Ejercicio02 {

    public static void main(String[] args) {
        Laberinto laberinto = new Laberinto(4,4);
        laberinto.setCasilla(0, 0, false, true, true, false);
        laberinto.setCasilla(0, 1, false, true, false, true);
        laberinto.setCasilla(0, 2, false, true, true, true);
        laberinto.setCasilla(0, 3, false, false, false, true);
        laberinto.setCasilla(1, 0, true, true, true, false);
        laberinto.setCasilla(1, 1, false, false, false, true);
        laberinto.setCasilla(1, 2, true, false, true, false);
        laberinto.setCasilla(1, 3, false, false, true, false);
        laberinto.setCasilla(2, 0, true, true, true, false);
        laberinto.setCasilla(2, 1, false, true, true, true);
        laberinto.setCasilla(2, 2, true, true, true, true);
        laberinto.setCasilla(2, 3, true, false, true, true);
        laberinto.setCasilla(3, 0, true, false, false, false);
        laberinto.setCasilla(3, 1, true, false, false, false);
        laberinto.setCasilla(3, 2, true, true, false, false);
        laberinto.setCasilla(3, 3, true, false, false, true);

        ArrayList<Casilla> menorActual = new ArrayList<>();
        int[] inicio = {0,0};
        int[] fin = {3,3};
        menorActual = laberinto.longitudMinima(inicio, fin);
        System.out.println(menorActual.toString());
        System.out.println(menorActual.size());

    }

}
