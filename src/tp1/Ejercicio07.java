package tp1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ejercicio07 {

    public List<Object> construir(List<Object> listaA, List<Object> listaB) {
        List<Object> aux = new ArrayList<>();
        Iterator<Object> it = listaA.iterator();
        while (it.hasNext()){
            Object o = it.next();
            if (!listaB.contains(o))
                aux.add(o);
        }
       /* for (Object o :
                listaA) {
            if (listaB.contains(o))
                aux.add(o);
        }*/
        return aux;
    }
}
