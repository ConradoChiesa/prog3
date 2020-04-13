package tp1.ejercicio1;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MySimpleLikedList implements Iterable<MySimpleLikedList> {
    protected Node first;
    private int size;
    public MySimpleLikedList() {
        this.first=null;
    }

    public void insertFront(Object o) {
        Node tmp = new Node(o, null);
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
    public Iterator<MySimpleLikedList> iterator() {
        Iterator MyIt = new MyIterator();
        return MyIt;
    }

    @Override
    public void forEach(Consumer<? super MySimpleLikedList> action) {

    }

    @Override
    public Spliterator<MySimpleLikedList> spliterator() {
        return null;
    }



    protected class MyIterator implements Iterator<MySimpleLikedList> {
        protected int position;
        public MyIterator() {
            position = 0;
        }

        @Override
        public boolean hasNext() {
            boolean result;
            if (position<size())
                result = true;
            else result = false;
            return result;
        }

        public MySimpleLikedList next() {
            return (MySimpleLikedList) MySimpleLikedList.this.get(position);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("No solicitado en el practico");
        }

        @Override
        public void forEachRemaining(Consumer<? super MySimpleLikedList> action) {

        }
    }
}
