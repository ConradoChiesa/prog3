package tp1.ejercicio1;

import java.util.Iterator;

public class MySimpleLikedList implements Iterable<Integer> {
    protected Node first;
    private int size;
    public MySimpleLikedList() {
        this.first=null;
    }

    public void insertFront(Integer i) {
        Node tmp = new Node(i, null);
        tmp.setNext(first);
        this.first=tmp;
        this.size++;
    }

    public Object extractFront() {
        Node n = first;
        this.first = n.getNext();
        this.size--;
        return n;
    }

    public void print(int n){
        System.out.println();
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int size() {
        return this.size;
    }

    public Node getFirst() {
        return first;
    }

    public Object get(int index) {
        if (index<this.size) {
            Node n = this.first;
            for (int i = 0; i < index; i++) {
                n = n.getNext();
            }
            return n.getInfo();
        }
        return null;
    }

    public int indexOf(Object o) {
        int index=0;
        while (index<this.size) {
            if (this.get(index).equals(o))
                return index;
            else index++;
        }
        return -1;
    }

    public void subSecuence(MySimpleLikedList ml) {
        int index = 0;
        while (index<ml.size()){

        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator(this.first);
    }
}
