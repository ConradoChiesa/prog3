package tp1.ejercicio1;

public class MySimpleLikedList {
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
        if (this.first==null) return true;
        else return false;
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
}
