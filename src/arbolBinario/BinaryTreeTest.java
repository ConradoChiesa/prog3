package arbolBinario;

import javax.swing.*;

public class BinaryTreeTest {
    private static int MAX = 100;
    public static void main(String[] args) {

        BinaryTree ABB = new BinaryTree();
        BinaryNode raiz = new BinaryNode(10);
        for (int i = 0; i < MAX; i++) {
            BinaryNode nuevo = new BinaryNode((int) Math.floor(Math.random()*10));
            ABB.insertOrganizedNode(nuevo);
        }

    }
}
