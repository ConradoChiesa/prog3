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

    // O(1) simplemente busca el valor en la variable
    public int getRoot() {
        return this.root.getValue();
    }

    // O(1)
    public boolean isEmpty() {
        return this.root == null;
    }

    // O(heigth) en el peor de los casos el nodo a insertar pasara a ser nodo hoja
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
                add(actual.getLeft(), value);
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

    // O(heigt) En el peor de los casos el elemento es hoja de la rama mas larga
    public boolean hasElem(int sherching) {
        return hasElem(this.root, sherching);
    }

    private boolean hasElem( TreeNode tn, int sherching) {
        boolean hasIt;
        if (tn == null) {
            return false;
        }
        if (tn.getValue() == sherching) {
            return true;
        }
        if (sherching < tn.getValue()) {
             hasIt = hasElem(tn.getLeft(), sherching);
            if(hasIt) {
                return true;
            }

        } else {
            hasIt = hasElem(tn.getRight(), sherching);
            return hasIt;
        }
        return hasIt;
    }

    //  Este metodo quería no se void porque era el camino facíl y me encapriche con el boolean
    //  O(heigth)
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

    //  O(heigth del subarbol izq) Este y el sigiente metodo revisa los nodos hasta un maxímo de la mitad de los nodos del subarbol
    private int minValue(TreeNode tn) {
        if(tn.getLeft() != null) {
            return minValue(tn.getLeft());
        }
        return tn.getValue();
    }

    public int maxValue() {
        return maxValue(this.root);
    }
    //  O(Height del subarbol derecho)
    private int maxValue(TreeNode tn) {
        if (tn.getRight()!=null) {
            return maxValue(tn.getRight());
        }
        return tn.getValue();
    }

    //  O(nodos) Se deben recorrer todos los nodos
    public int getHeight() {
        return getNodeHeight(this.root);
    }

    private int getNodeHeight(TreeNode tn) {
        if(tn == null) {
            return -1;
        }
        return Math.max(getNodeHeight(tn.getLeft()), getNodeHeight(tn.getRight()))+1;
    }

    //  O(Nodos) En cualquiera de los casos tengo que recorrer todos los nodos para preguntarles si son hoja
    public List getLongestBranch() {
        return getLongestBranch(this.root);
    }

    private List getLongestBranch(TreeNode tn) {
        List<Integer> currentLongest = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        if (tn.isLeaf()) {
            currentLongest.add(tn.getValue());
            return currentLongest;
        } else {
            if (tn.getLeft() != null) {
                left.add(tn.getValue());
                left.addAll(getLongestBranch(tn.getLeft()));
            }
            if (tn.getRight() != null) {
                right.add(tn.getValue());
                right.addAll(getLongestBranch(tn.getRight()));
            }
            //En este caso si las listas son iguales retorna la de menores valores
            if (right.size() > left.size()) {
                currentLongest.addAll(right);
            } else {
                currentLongest.addAll(left);
            }
        }
        return currentLongest;
    }

    //  O(nodos) para todos los metodos de print ya que recorre todo el arbol
    public void printPostorder() {
        printPostorder(this.root);
    }

    private void printPostorder(TreeNode tn) {
        if(tn == null) {
            System.out.print("-");
            return;
        }
        printPostorder(tn.getLeft());
        printPostorder(tn.getRight());
        System.out.print(tn.getValue()+ " ");
    }

    public void printPreOrder() {
        printPreOrder(this.root);
    }

    private void printPreOrder(TreeNode tn) {
        if(tn == null) {
            System.out.print("-");
            return;
        }
        System.out.print(tn.getValue()+ " ");
        printPreOrder(tn.getLeft());
        printPreOrder(tn.getRight());
    }

    public void printInOrder() {
        printInOrder(this.root);
    }

    private void printInOrder(TreeNode tn) {
        if(tn == null) {
            System.out.print("-");
            return;
        }
        printInOrder(tn.getLeft());
        System.out.print(tn.getValue()+ " ");
        printInOrder(tn.getRight());
    }

    //  O(heigth) en cualquier caso no recorre más que la altura
    public void getFrontera(List<Integer> list) {
        getFrontera(this.root, list);
    }

    private void getFrontera(TreeNode tn, List<Integer> list) {
        if (tn.isLeaf()) {
            list.add(tn.getValue());
        }
        if (tn.getLeft() != null) {
            getFrontera(tn.getLeft(), list);
        }
        if (tn.getRight() != null) {
            getFrontera(tn.getRight(), list);
        }
    }

    //  O(sumatoria desde 0 hasta nivel de 2^nivel) Va a recorrer los nodos del nivel solicitado más los nodos de los niveles anteriores
    public void getElemAtLevel(int searchLevel, List<Integer> elemAtLevel) {
        getElemAtLevel(searchLevel, this.root, 0, elemAtLevel);
    }

    private void getElemAtLevel(int searchLevel, TreeNode tn, int currentLevel, List<Integer> elemAtLevel) {
        TreeNode current = tn;
        if (searchLevel == currentLevel) {
            elemAtLevel.add(tn.getValue());
            return;
        }
        if (currentLevel < searchLevel && tn.getLeft() != null) {
            getElemAtLevel(searchLevel, tn.getLeft(), currentLevel + 1, elemAtLevel);
        }
        if (currentLevel < searchLevel && tn.getRight() != null) {
            getElemAtLevel(searchLevel, tn.getRight(), currentLevel + 1, elemAtLevel);
        }
    }

}
