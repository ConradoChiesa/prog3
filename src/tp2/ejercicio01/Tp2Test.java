package tp2.ejercicio01;

import tp2.ejercicio03.OrganizeMethods;

public class Tp2Test {
    public static void main(String[] args) {
        DeterminateIfOrder det= new DeterminateIfOrder();
        int []arr= {3,2,4,7,12,5,1};
        System.out.println(det.minToMax(arr, 0, true));
        arr=OrganizeMethods.burbuja(arr);
        System.out.println(det.minToMax(arr, 0, true));
        OrganizeMethods.printArray(arr);
    }
}
