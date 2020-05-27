package tp4;

public class Ejercicio01 {
    public static void main(String[] args) {
        System.out.println(cantMinMonedas(289));
    }

    static int[] monedas = { 100, 25, 10, 5, 1 };
    static int[] cantidadesMonedas = new int[monedas.length];


    public static String cantMinMonedas(int aPagar) {
        int cantMonedas = 0;
        int index = 0;
        String rta = "";
        while (aPagar > 0 && index < monedas.length) {
            while (aPagar >= monedas[index]) {
                aPagar -= monedas[index];
                cantMonedas++;
                cantidadesMonedas[index] += 1;
            }
            index++;
        }
        for (int i = 0; i < cantidadesMonedas.length; i++) {
            if (cantidadesMonedas[i] != 0) {
                rta += cantidadesMonedas[i] + " Monedas de $" + monedas[i] + "\n";
            }
        }
        rta += "Son un total de "+ cantMonedas + " monedas.";
        return rta;
    }

}
