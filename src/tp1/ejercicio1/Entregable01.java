package tp1.ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Entregable01 {
    private List<List<Integer>> list;
    private MySimpleLikedList msll;
    public Entregable01(MySimpleLikedList msll) {
        this.msll = msll;
        this.list = new ArrayList<List<Integer>>();

    }

    public List<List<Integer>> getList() {
        List<Integer> aux = new ArrayList<>();
        Iterator<Integer> it = msll.iterator();
        int after=msll.getFirst().getInfo();
        while (it.hasNext()) {
            int n = it.next();
            if (!aux.isEmpty() && after>=n) {
                if (aux.size() > 1) {
                    list.add(aux);
                    aux = new ArrayList<>();
                } else {
                    aux.clear();
                }
            }
            aux.add(n);
            after=n;
        }
        if (aux.size()>1)
            list.add(aux);
        return list;
    }


}
