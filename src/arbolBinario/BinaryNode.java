package arbolBinario;

public class BinaryNode {
    private BinaryNode left;
    private BinaryNode right;
    private Integer dataInteger;

    public BinaryNode() {
        this.left=null;
        this.right=null;
        this.dataInteger=0;
    }

    public BinaryNode(int data) {
        this.left=null;
        this.right=null;
        this.dataInteger=data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    private void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    private void setRight(BinaryNode right) {
        this.right = right;
    }

    public Integer getDataInteger() {
        return dataInteger;
    }

    public void setDataInteger(Integer dataInteger) {
        this.dataInteger = dataInteger;
    }

    public boolean insertNode (BinaryNode node) {
        boolean inserted = false;
        if (node.getDataInteger()<this.getDataInteger()) {
            if (this.getLeft()==null) {
                this.setLeft(node);
                inserted=true;
            } else {
                this.getLeft().insertNode(node);
            }
        } else {
            if (this.getRight()==null) {
                this.setRight(node);
                inserted=true;
            } else {
                this.getRight().insertNode(node);
            }
        }
        return inserted;
    }
}
