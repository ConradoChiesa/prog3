package tp1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Teoria01 {
    private static int MAX = 1000000;
    List<Integer> dni;

    public Teoria01() {
        dni = new ArrayList<>();
    }

    public void completeDni() {
        for (int i=0; i<MAX; i++) {
            dni.add((int)Math.floor(Math.random()*10000000+1));
        }
        Collections.sort(dni);
    }

    public void printDni() {
        for (Integer d :
                dni) {
            System.out.println(d.toString());
        }
    }

    public int checkIfExist(int n) {
    return -1;
    }
}
