package DDR_backracking;

import java.util.ArrayList;

public class Ejer_20_discoduroderoer {

    public static void main(String[] args) {
        int n = 4;
        ArrayList<Integer> numeros = new ArrayList<>();
        combinacionesSuma(n, numeros, 0);
    }

    public static void combinacionesSuma(int numero, ArrayList<Integer> numeros, int suma) {

        if (suma == numero) {
            System.out.println(numeros);
        } else {
            for (int i = 1; i <= numero; i++) {
                suma += i;
                if (suma <= numero) {
                    numeros.add(i);
                    combinacionesSuma(numero, numeros, suma);
                    numeros.remove(numeros.indexOf(i));
                }
                suma -= i;
            }
        }
    }
}
