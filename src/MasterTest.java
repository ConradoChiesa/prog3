import tp1.Teoria01;
import tp1.ejercicio1.MySimpleLikedList;

public class MasterTest {
    public static void main(String[] args) {
        MySimpleLikedList msll = new MySimpleLikedList();
//        System.out.println(msll.isEmpty());
        String s = "String de prueba para guardar";
        Integer i = 25;
        msll.insertFront(s);
        msll.insertFront(i);
        System.out.println("Lista vacia: " + msll.isEmpty());
        System.out.println("Tamaño de la lista: " + msll.size());
        System.out.println(msll.get(0));
        System.out.println(msll.get(1));
        msll.extractFront();
        System.out.println(msll.get(0));
    }
}
