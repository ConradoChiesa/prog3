import tp1.Teoria01;
import tp1.ejercicio03.PilaDeLista;
import tp1.ejercicio1.MySimpleLikedList;

public class MasterTest {
    public static void main(String[] args) {
        MySimpleLikedList msll = new MySimpleLikedList();
//        System.out.println(msll.isEmpty());
        String s = "String de prueba para guardar";
        Integer i = 25, e = 32;
        msll.insertFront(s);
        msll.insertFront(i);
        msll.insertFront(e);
        System.out.println("Lista vacia: " + msll.isEmpty());
        System.out.println("Tamaño de la lista: " + msll.size());
        System.out.println(msll.get(0));
        System.out.println(msll.get(1));
        System.out.println(msll.get(2));
        msll.extractFront();
        System.out.println(msll.get(0));
        System.out.println(msll.indexOf(25));
        PilaDeLista pl = new PilaDeLista();
        pl.push(i);
        pl.push(e);
        pl.push(45);
        pl.push(4543);
        pl.push(6);
        pl.push(743);
        System.out.println("Pila de Lista");
        System.out.println(pl.top());
        pl.reverse();
        System.out.println(pl.top());
    }
}
