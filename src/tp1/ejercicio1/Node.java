package tp1.ejercicio1;

public class Node {

    private Integer info;
    private Node next;

    public Node() {
        this.info=null;
        this.next=null;
    }

    public Node(Integer o, Node n) {
        this.info=o;
        this.next=n;
    }

    public Integer getInfo() {
        return this.info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
