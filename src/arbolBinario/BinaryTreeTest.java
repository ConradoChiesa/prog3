package arbolBinario;

import java.util.*;

public class BinaryTreeTest {
    private static int MAX = 15;
    private static int DEL = 10;
    private static int FRONTERA = 2;
    public static void main(String[] args) {
        List<Integer> integerArrayList = new ArrayList<>(MAX);
        List<Integer> frontera = new ArrayList<>();
        List<Integer> elemetAtLevel = new ArrayList<>();
        List<Integer> longestBranch = new ArrayList<>();
        Tree ABB = new Tree();
//      Hago que el nodo raiz sea el root para borrarlo y ver que pasa.
//        integerArrayList.add(DEL);
        while (integerArrayList.size()<MAX) {
            int num = (int) Math.floor(Math.random()*40);
            if (!integerArrayList.contains(num)){
                integerArrayList.add(num);
//                Descomentar la siguiente linea para imprimir el orden de como se agregan los nodos
//                System.out.println("Agregando :" + num);
            }
        }
        Iterator<Integer> it = integerArrayList.iterator();
        while (it.hasNext()) {
            ABB.add(it.next());
        }
        System.out.println("Nodo Raíz: "+ ABB.getRoot() + "\n");
        System.out.println("Impresión en orden");
        ABB.printInOrder();
        System.out.println("\n");
        System.out.println("Impresión en pos orden");
        ABB.printPostorder();
        System.out.println("\n");
        System.out.println("Impresión en pre orden");
        ABB.printPreOrder();
        System.out.println("\n");
        System.out.println("El elemento mayor es: " + ABB.maxValue());
        System.out.println("La rama más larga tiene " + ABB.getHeight() + " nodos.");
        System.out.println("Es "+ ABB.hasElem(DEL) + " que tiene el valor " + DEL);
        System.out.println(ABB.delete(DEL));
        System.out.println("Nodo Raíz: "+ ABB.getRoot() + "\n");
        ABB.printInOrder();
        ABB.getFrontera(frontera);
        System.out.println("\n");
        System.out.println("Impresión de fronteras");
        for (Integer tn :
                frontera) {
            System.out.print(tn + " ");
        }
        ABB.getElemAtLevel(FRONTERA, elemetAtLevel);
        System.out.println("\n");
        System.out.println("Impresión de nivel " + FRONTERA);
        for (Integer tn :
                elemetAtLevel) {
            System.out.print(tn + " ");
        }
        longestBranch = ABB.getLongestBranch();
        System.out.println("\n");
        System.out.println("Impresion longestBranch");
        for (Integer tn :
                longestBranch) {
            System.out.print(tn + " ");
        }
    }
}
