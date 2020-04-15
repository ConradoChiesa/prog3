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
            if (node.getDataInteger()<this.raiz.getDataInteger()) {
                this.raiz.setLeft(node);
            } else if (node.getDataInteger()>this.raiz.getDataInteger()) {
                this.raiz.setRight(node);
            }
        }
        return inserted;
    }
}
