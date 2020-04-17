package tp1.ejercicio1;

import java.util.Iterator;

public class MyIterator implements Iterator<Integer> {
    private Node navegator;
    public MyIterator(Node first) {
        this.navegator=first;
    }

    @Override
    public boolean hasNext() {
        return this.navegator!=null;
    }

    @Override
    public Integer next() {
        Integer info = this.navegator.getInfo();
        this.navegator = this.navegator.getNext();
        return info;
    }
}
