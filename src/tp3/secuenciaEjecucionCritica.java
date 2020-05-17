package tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class secuenciaEjecucionCritica {

    private HashMap<Integer, Tarea> indiceTareas;
    private GrafoDirigido gd;
    private int maxDuration;
    private ArrayList<Integer> secuenciaMayor;

    public secuenciaEjecucionCritica(GrafoDirigido gd) {
        this.gd = gd;
        this.indiceTareas = new HashMap<>();
        this.maxDuration = 0;
        this.secuenciaMayor = new ArrayList<>();

    }
// O(1) com es unHashMap accede por caveal espacio directo de arreglo.
    public boolean agregarTarea(Tarea tarea, int verticeId) {
//        agragar tarea si existe el vertice
        boolean setted = false;
//        No agregar vertice
        if (gd.contieneVertice(verticeId)) {
            indiceTareas.put(verticeId, tarea);
            setted = true;
        }
        return setted;
    }

    public ArrayList secuenciaEjecucionCritica(int start) {
        ArrayList<Integer> secuencia = new ArrayList<>();
        secuencia.add(start);
        secunciaCritica(start, secuencia, 0);
        return secuenciaMayor;

    }

// O(vertices) ya que va a recorrer todos los vertices de grafo
    private void secunciaCritica(int current, ArrayList secuencia, int sumCurrent) {
        if (!gd.isFinal(current)) {
            Iterator<Arco> arcos = gd.obtenerArcos(current);
            while (arcos.hasNext()) {
                Arco<Integer> a = arcos.next();
                secuencia.add(a.getVerticeDestino());
                sumCurrent += a.getEtiqueta();
                sumCurrent += indiceTareas.get(a.getVerticeDestino()).getDuration();
                secunciaCritica(a.getVerticeDestino(), secuencia, sumCurrent);
                secuencia.remove(secuencia.size()-1);
                sumCurrent -= a.getEtiqueta();
                sumCurrent -= indiceTareas.get(a.getVerticeDestino()).getDuration();
            }
        } else {
            if (sumCurrent > maxDuration) {
                maxDuration = sumCurrent;
                secuenciaMayor.clear();
                secuenciaMayor.addAll(secuencia);
            }
        }
    }

}
