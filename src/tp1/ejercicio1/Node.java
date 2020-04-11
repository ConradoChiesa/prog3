package tp1.ejercicio1;

public class Node {

    private Object info;
    private Node next;

    public Node() {
        this.info=null;
        this.next=null;
    }

    public Node(Object o, Node n) {
        this.info=o;
        this.next=n;
    }

    public Object getInfo() {
        return this.info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
