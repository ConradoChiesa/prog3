package tp1;

public class BusquedaBinaria {

    public static int binariaRecursiva(int[] A, int X, int inicio, int fin) {
        int medio;
        if (fin <  inicio) return -1;
        else {
            medio = (inicio +fin)/2;
            if (X > A[medio])
                return binariaRecursiva(A, X, medio+1, fin);
            else
                if(X < A[medio])
                    return binariaRecursiva(A,X, inicio, medio-1);
                else
                    return medio;
        }
    }
}
