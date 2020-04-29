package tp2.ejercicio03;

public class OrganizeMethods {

    public static int[] selection(int arr[]) {
        int i, j, menor, pos, tmp;
        for (i = 0; i < arr.length - 1; i++) {
            menor = arr[i];
            pos = i;
            for (j = i + 1; j < arr.length; j++){
                if (arr[j] < menor) {
                    menor = arr[j];
                    pos = j;
                }
            }
            if (pos != i){
                tmp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = tmp;
            }
        }
        return arr;
    }

    public static int[] burbuja(int[] arr) {
        int auxiliar;
        for(int i = 1; i < arr.length; i++) {
            for(int j = 0; j < arr.length-i; j++) {
                if(arr[j] > arr[j+1]) {
                    auxiliar = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = auxiliar;
                }
            }
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
