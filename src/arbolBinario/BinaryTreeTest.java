package arbolBinario;

import java.util.*;

public class BinaryTreeTest {
    private static int MAX = 15;
    private static int DEL = 10;
    public static void main(String[] args) {

        Tree ABB = new Tree();
//        ABB.add(10);
//        for (int i = 0; i < MAX; i++) {
//            int nuevo = (int) Math.floor(Math.random()*1000);
//            ABB.add(nuevo);
//        }
        List<Integer> aux = new ArrayList<>(MAX);
        while (aux.size()<MAX) {
            int num = (int) Math.floor(Math.random()*40);
            if (!aux.contains(num)) aux.add(num);
        }
        Iterator<Integer> it = aux.iterator();
        while (it.hasNext())
            ABB.add(it.next());
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
        System.out.println("\n");

    }
}
