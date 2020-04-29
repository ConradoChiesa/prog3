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

    private void add(TreeNode actual, int value) {
        if (actual.getValue() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(),value);
            }
        } else {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(), value);
            }
        }
    }

    public int getRoot() {
        return this.root.getValue();
    }

    public boolean hasElem(int i, TreeNode tn) {
        boolean hasIt;
        if (isEmpty())
            hasIt = false;
        else {
            if (root.getValue()==i)
                hasIt = true;
            else if (i < root.getValue()){
                hasIt = hasElem(i, tn.getLeft());
            } else {
                hasIt = hasElem(i, tn.getRight());
            }
        }

        return hasIt;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean delete(int i) {
        boolean deleted = false;

        return deleted;
    }

    public int getHeight(TreeNode tn) {
        int lefth = getHeight(tn.getLeft());
        int righth = getHeight(tn.getRight());
        if (tn == null)
            return -1;
        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }

    public void printPostorder(TreeNode tn) {
        if(tn == null){
            System.out.println("-");
            return;
        }
        printPostorder(tn.getLeft());
        printPostorder(tn.getRight());
        System.out.print(tn.getValue()+ " ");

    }

    public void printPreOrder(TreeNode tn) {
        if(tn == null) {
            System.out.println("-");
            return;
        }
        System.out.print(tn.getValue()+ " ");
        printPreOrder(tn.getLeft());
        printPreOrder(tn.getRight());
    }

    public void printInOrder(TreeNode tn) {
        if(tn == null){
            System.out.println("-");
            return;
        }
        printInOrder(tn.getLeft());
        System.out.print(tn.getValue()+ " ");
        printInOrder(tn.getRight());
    }

    public List getLongestBranch() {
        List<Integer> aux = new ArrayList<>();
        return aux;
    }

    public List getFrontera() {
        List<Integer> aux = new ArrayList<>();
        return aux;
    }

    public int getMaxElem(TreeNode tn) {
        TreeNode current = tn;
        while (current.getRight()!=null)
            current = current.getRight();
        return current.getValue();
    }

    public List getElemAtLevel(int i) {
        List<Integer> aux= new ArrayList();
        return aux;
    }

}
