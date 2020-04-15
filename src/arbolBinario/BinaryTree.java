package arbolBinario;

public class BinaryTree {
    private BinaryNode raiz;

    public BinaryTree() {
        this.raiz=null;
    }

    public BinaryTree(BinaryNode raiz) {
        this.raiz=raiz;
    }

    public boolean insertOrganizedNode(BinaryNode node) {
        boolean inserted = false;
        if (this.raiz==null){
            this.raiz=node;
            inserted=true;
        }
        else {
//            if (node.getDataInteger()<this.raiz.getDataInteger()) {
//                this.raiz.setLeft(node);
//            } else if (node.getDataInteger()>this.raiz.getDataInteger()) {
//                this.raiz.setRight(node);
//            }
            inserted = this.raiz.insertNode(node);
        }
        return inserted;
    }

    public void inOrder(){

        if (this.raiz!=null) {

            raiz.getLeft().inOrder();

            System.out.print( raiz.dato + ", "  );

            raiz.hd.inOrder();

        }

    }
}
