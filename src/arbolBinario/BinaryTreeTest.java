package arbolBinario;

import java.util.*;

public class BinaryTreeTest {
    private static int MAX = 15;
    private static int DEL = 10;
    private static int FRONTERA = 2;
    public static void main(String[] args) {
        List<Integer> integerArrayList = new ArrayList<>(MAX);
        List<TreeNode> elemetAtLevel = new ArrayList<>();
        List<TreeNode> longestBranch = new ArrayList<>();
        Tree ABB = new Tree();

        while (integerArrayList.size()<MAX) {
            int num = (int) Math.floor(Math.random()*40);
            if (!integerArrayList.contains(num)){
                integerArrayList.add(num);
//                Descomentar la siguiente linea para imprimir el orden de como se agregan los nodos
                System.out.println("Agregando :" + num);
            }
        }
        Iterator<Integer> it = integerArrayList.iterator();
        while (it.hasNext()) {
            ABB.add(it.next());
        }
        System.out.println("Nodo Raíz: "+ ABB.getRoot() + "\n");
        System.out.println("Impresión en orden");
        ABB.printInOrder(ABB.getRootNode());
        System.out.println("\n");
        System.out.println("Impresión en pos orden");
        ABB.printPostorder(ABB.getRootNode());
        System.out.println("\n");
        System.out.println("Impresión en pre orden");
        ABB.printPreOrder(ABB.getRootNode());
        System.out.println("\n");
        System.out.println("El elemento mayor es: " + ABB.getMaxElem(ABB.getRootNode()));
        System.out.println("La rama más larga tiene " + ABB.getHeight(ABB.getRootNode()) + " nodos.");
        System.out.println("Es "+ ABB.hasElem(ABB.getRootNode(), DEL) + " que tiene el valor " + DEL);
        System.out.println(ABB.delete(DEL));
        ABB.printInOrder(ABB.getRootNode());
        List<TreeNode> frontera = new ArrayList<>();
        ABB.getFrontera(ABB.getRootNode(), frontera);
        System.out.println("\n");
        System.out.println("Impresión de fronteras");
        for (TreeNode tn :
                frontera) {
            System.out.print(tn.getValue() + " ");
        }
        ABB.getElemAtLevel(FRONTERA, ABB.getRootNode(), 0, elemetAtLevel);
        System.out.println("\n");
        System.out.println("Impresión de nivel " + FRONTERA);
        for (TreeNode tn :
                elemetAtLevel) {
            System.out.print(tn.getValue() + " ");
        }
        ABB.getLongestBranch(longestBranch, longestBranch, ABB.getRootNode());
        System.out.println("\n");
        System.out.println("Impresion longestBranch");
        for (TreeNode tn :
                longestBranch) {
            System.out.print(tn.getValue() + " ");
        }
    }
}
