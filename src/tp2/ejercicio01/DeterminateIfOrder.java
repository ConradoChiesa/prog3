package tp2.ejercicio01;
/*
 * Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado.
 */
public class DeterminateIfOrder {

    public boolean minToMax(int[] arr, int posArr, boolean organized) {
        if (organized && posArr<arr.length-1) {
/*            if(arr[posArr]>arr[posArr+1]) {
 *               organized=false;
 *          } else {
 *               organized = minToMax(arr, posArr+1, organized);
 *          }
 */
        organized = (arr[posArr]>arr[posArr+1]) ? false : minToMax(arr, posArr+1, organized);
        }
        return organized;
    }
}
