package arbolBinario;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private TreeNode root;
    private boolean deleted;

    public Tree() {
        this.root = null;
        this.deleted = false;
    }

    public TreeNode getRootNode() {
        return this.root;
    }

    public boolean isEmpty() {
        return this.root == null;
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

    public boolean hasElem( TreeNode tn, int sherching) {
        if (tn == null) {
            return false;
        }
        if (tn.getValue() == sherching) {
            return true;
        }
        boolean hasIt1 = hasElem(tn.getLeft(), sherching);
        if(hasIt1) {
            return true;
        }
        boolean hasIt2 = hasElem(tn.getRight(), sherching);
        return hasIt2;
    }

//Este metodo quería no se void porque era el camino facíl y me encapriche con el boolean
    public boolean delete(int value) {
        boolean deleted;
        deleteNode(this.root, value);
        deleted = this.deleted ? true : setDeleted(false);
        return deleted;
    }

    private TreeNode deleteNode(TreeNode tn, int value) {
        if(tn == null) {
            return null;
        }
        if(value < tn.getValue()) {
            tn.setLeft(deleteNode(tn.getLeft(), value));
        } else if(value > tn.getValue()) {
            tn.setRight(deleteNode(tn.getRight(), value));
        } else {
            if(tn.isLeaf()) {
                setDeleted(true);
                return null;
            } else if(tn.getLeft() == null) {
                setDeleted(true);
                return tn.getRight();
            } else if(tn.getRight() == null) {
                setDeleted(true);
                return tn.getLeft();
            } else {
                int minValue = minValue(tn.getRight());
                tn.setValue(minValue);
                tn.setRight(deleteNode(tn.getRight(), minValue));
            }
        }
        return tn;
    }

    private boolean setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this.deleted;
    }

    private int minValue(TreeNode tn) {
        if(tn.getLeft() != null) {
            return minValue(tn.getLeft());
        }
        return tn.getValue();
    }

    public int getHeight(TreeNode tn) {
        return getNodeHeight(tn);
    }

    private int getNodeHeight(TreeNode tn) {
        if(tn == null) {
            return -1;
        }
        return Math.max(getNodeHeight(tn.getLeft()), getNodeHeight(tn.getRight()))+1;
    }
//  Metodo con fallas de implementación
    public List getLongestBranch(List<TreeNode> list, List<TreeNode> currentLongest, TreeNode tn) {
//        List<TreeNode> currentLongest = new ArrayList<>();
        if (tn.isLeaf()) {
            if (list.size() > currentLongest.size()) {
                currentLongest = new ArrayList<>();
                currentLongest.addAll(list);
            }
        }
        if (tn.getLeft() != null) {
            getLongestBranch(list, currentLongest, tn.getLeft());
            list.add(tn.getLeft());
        } else {
            list.remove(tn);
        }
        if (tn.getRight() != null) {
            getLongestBranch(list, currentLongest, tn.getRight());
            list.add(tn.getRight());
        } else {
            list.remove(tn);
        }
        return currentLongest;
    }
//La complejidad es de O(TreeNode) para todos los metodos de print ya que recorre todo el arbol
    public void printPostorder(TreeNode tn) {
        if(tn == null) {
            System.out.print("-");
            return;
        }
        printPostorder(tn.getLeft());
        printPostorder(tn.getRight());
        System.out.print(tn.getValue()+ " ");
    }

    public void printPreOrder(TreeNode tn) {
        if(tn == null) {
            System.out.print("-");
            return;
        }
        System.out.print(tn.getValue()+ " ");
        printPreOrder(tn.getLeft());
        printPreOrder(tn.getRight());
    }

    public void printInOrder(TreeNode tn) {
        if(tn == null) {
            System.out.print("-");
            return;
        }
        printInOrder(tn.getLeft());
        System.out.print(tn.getValue()+ " ");
        printInOrder(tn.getRight());
    }
//O(TreeNode) en cualquier caso tiene que recorrer todos los nodos
    public void getFrontera(TreeNode tn, List<TreeNode> list) {
        if (tn.isLeaf()) {
            list.add(tn);
        }
        if (tn.getLeft() != null) {
            getFrontera(tn.getLeft(), list);
        }
        if (tn.getRight() != null) {
            getFrontera(tn.getRight(), list);
        }
    }
//O(TreeNode) o de O(height) no esoty muy seguro pero considero el peor de los casos cada nodo ingresado tenga un valor
// mayor que el anterior, estando todos los getLeft()==null;
    public int getMaxElem(TreeNode tn) {
        TreeNode current = tn;
        while (current.getRight()!=null) {
            current = current.getRight();
        }
        return current.getValue();
    }
//Mismo ejemplo anterior solo que devulve el nodo y no el valor, no sabía cual había que implemetar por eso hice ambos
    public TreeNode getMaxElemNode(TreeNode tn) {
        TreeNode current = tn;
        while (current.getRight()!=null) {
            current = current.getRight();
        }
        return current;
    }
//
    public void getElemAtLevel(int searchLevel, TreeNode tn, int currentLevel, List<TreeNode> list) {
        TreeNode current = tn;
        if (searchLevel == currentLevel) {
            list.add(tn);
            return;
        }
        if (currentLevel < searchLevel && tn.getLeft() != null) {
            getElemAtLevel(searchLevel, tn.getLeft(), currentLevel + 1, list);
        }
        if (currentLevel < searchLevel && tn.getRight() != null) {
            getElemAtLevel(searchLevel, tn.getRight(), currentLevel + 1, list);
        }
    }

}
