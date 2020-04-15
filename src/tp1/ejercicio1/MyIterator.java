package tp1.ejercicio1;

import java.util.Iterator;

public class MyIterator implements Iterator<Object> {
    private Node navegator;
    public MyIterator(Node first) {

    }

    @Override
    public boolean hasNext() {
        return this.navegator==null;
    }

    @Override
    public Object next() {
        Object info= this.navegator.getInfo();
        this.navegator=this.navegator.getNext();
        return info;
    }
}
