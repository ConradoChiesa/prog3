package arbolBinario;

public class BinaryTreeTest {
    private static int MAX = 10;
    public static void main(String[] args) {

        Tree ABB = new Tree();
        TreeNode raiz = new TreeNode(10);
        ABB.add(10);
        for (int i = 0; i < MAX; i++) {
            int nuevo = (int) Math.floor(Math.random()*1000);
            ABB.add(nuevo);
        }

        ABB.printInOrder(ABB.getRootNode());
        ABB.printPostorder(ABB.getRootNode());
    }
}
