package arbolBinario;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BinaryTreeTest {
    private static int MAX = 15;
    public static void main(String[] args) {

        Tree ABB = new Tree();
        TreeNode raiz = new TreeNode(10);
//        ABB.add(10);
//        for (int i = 0; i < MAX; i++) {
//            int nuevo = (int) Math.floor(Math.random()*1000);
//            ABB.add(nuevo);
//        }
        Set<Integer> aux = new HashSet<>(MAX);
        while (aux.size()<MAX) {
            aux.add((int) Math.floor(Math.random()*40));
        }
        Iterator<Integer> it = aux.iterator();
        while (it.hasNext())
            ABB.add(it.next());
        System.out.println("Impresión en orden");
        ABB.printInOrder(ABB.getRootNode());
        System.out.println();
        System.out.println("Impresión en pos orden");
        ABB.printPostorder(ABB.getRootNode());
        System.out.println("Impresión en pre orden");
        ABB.printPreOrder(ABB.getRootNode());
        System.out.println();
        System.out.println("El elemento mayor es: " + ABB.getMaxElem(ABB.getRootNode()));
        System.out.println("La rama más larga tiene " + ABB.getHeight(ABB.getRootNode()) + " nodos.");
        ABB.delete(10);
        ABB.printInOrder(ABB.getRootNode());
    }
}
