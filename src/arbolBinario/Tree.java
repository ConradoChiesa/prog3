package arbolBinario;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public TreeNode getRootNode() {
        return this.root;
    }

    public void add(int value) {
        if (this.root == null)
            this.root = new TreeNode(value);
        else
            this.add(this.root, value);
    }

    public int getRoot() {
        return this.root.getValue();
    }

    private void add(TreeNode actual, int value) {
        if (actual.getValue() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else
                add(actual.getLeft(),value);
        } else {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else
                add(actual.getRight(), value);
        }
    }

    public boolean hasElem(int i, TreeNode tn) {
        boolean hasIt;
        if (isEmpty())
            hasIt = false;
        else {
            if (root.getValue()==i)
                hasIt = true;
            else if (i < root.getValue())
                hasIt = hasElem(i, tn.getLeft());
            else
                hasIt = hasElem(i, tn.getRight());
        }
        return hasIt;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void delete(int value) {
        deleteNode(this.root, value);
    }

    private TreeNode deleteNode(TreeNode tn, int value) {
        if(tn == null) return tn;
        if(value < tn.getValue()) {
            tn.setLeft(deleteNode(tn.getLeft(), value));
        } else if(value > tn.getValue()) {
            tn.setRight(deleteNode(tn.getRight(), value));
        } else {
            if(tn.getLeft() == null && tn.getRight() == null) {
                return null;
            } else if(tn.getLeft() == null) {
                return tn.getRight();
            } else if(tn.getRight() == null) {
                return tn.getLeft();
            } else {
                int minValue = minValue(tn.getRight());
                tn.setValue(minValue);
                tn.setRight(deleteNode(tn.getRight(), minValue));
            }
        }
        return tn;
    }

    private int minValue(TreeNode node) {
        if(node.getLeft() != null) {
            return minValue(node.getLeft());
        }
        return node.getValue();
    }

    public int getHeight(TreeNode tn) {
        return getNodeHeight(this.root);
    }

    private int getNodeHeight(TreeNode tn) {
        if(tn == null)
            return -1;
        return Math.max(getNodeHeight(tn.getLeft()), getNodeHeight(tn.getRight()))+1;
    }

    public void printPostorder(TreeNode tn) {
        if(tn == null){
            return;
        }
        printPostorder(tn.getLeft());
        printPostorder(tn.getRight());
        System.out.print(tn.getValue()+ " ");

    }

    public void printPreOrder(TreeNode tn) {
        if(tn == null) {
            return;
        }
        System.out.print(tn.getValue()+ " ");
        printPreOrder(tn.getLeft());
        printPreOrder(tn.getRight());
    }

    public void printInOrder(TreeNode tn) {
        if(tn == null){
            return;
        }
        printInOrder(tn.getLeft());
        System.out.print(tn.getValue()+ " ");
        printInOrder(tn.getRight());
    }

    public List getLongestBranch() {
        List<TreeNode> aux = new ArrayList<>();
        return aux;
    }

    public List getFrontera() {
        List<TreeNode> aux = new ArrayList<>();
        return aux;
    }

    public int getMaxElem(TreeNode tn) {
        TreeNode current = tn;
        while (current.getRight()!=null)
            current = current.getRight();
        return current.getValue();
    }

    public TreeNode getMaxElemNode(TreeNode tn) {
        TreeNode current = tn;
        while (current.getRight()!=null)
            current = current.getRight();
        return current;
    }

    public List getElemAtLevel(int i) {
        List<TreeNode> aux= new ArrayList();
        return aux;
    }

}
