package tp1.ejercicio08;

import tp1.ejercicio1.Node;

public class DoubleNode extends Node {
    private Node after;

    public DoubleNode() {
        super(null, null);
        this.after=null;
    }

    public DoubleNode(DoubleNode next, Object o) {
        super(o, next);
        this.after=after;
    }


}
