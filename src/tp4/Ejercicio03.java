package tp4;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;

public class Ejercicio03 {

    public static ArrayList<Actividad> cantMaxActivComp(ArrayList<Actividad> actividades) {
        ArrayList<Actividad> mayorCantActividades = new ArrayList<>();
        Collections.sort(actividades);
        Iterator<Actividad> it = actividades.iterator();
        while (it.hasNext()) {
            Actividad act = it.next();
            if (mayorCantActividades.isEmpty()) {
                mayorCantActividades.add(act);
            } else {
                if (mayorCantActividades.get(mayorCantActividades.size() - 1).getFin() <= act.getIni()) {
                    mayorCantActividades.add(act);
                }
            }
        }
        return mayorCantActividades;
    }


    public static void main(String[] args) {
        ArrayList<Actividad> actividades = new ArrayList<>();
        Calendar meet01ini = Calendar.getInstance();
        meet01ini.set(Calendar.DAY_OF_WEEK, 2);
        meet01ini.set(Calendar.HOUR, 9);
        meet01ini.set(Calendar.MINUTE, 0);
        meet01ini.set(Calendar.SECOND, 0);
        Calendar meet02ini = Calendar.getInstance();
        meet02ini.set(Calendar.DAY_OF_MONTH, 25);
        meet02ini.set(Calendar.HOUR, 11);
        meet02ini.set(Calendar.MINUTE, 0);
        meet02ini.set(Calendar.SECOND, 0);
        actividades.add(new Actividad(20200525090000L, 20200525110000L));
        actividades.add(new Actividad(20200525100000L, 20200525120000L));
        actividades.add(new Actividad(20200525140000L, 20200525150000L));
        actividades.add(new Actividad(20200525100000L, 20200525130000L));
        actividades.add(new Actividad(20200525150000L, 20200525170000L));
        Collections.sort(actividades);
        System.out.println(Ejercicio03.cantMaxActivComp(actividades).toString());
        System.out.println(actividades.toString());
    }
}

/*
    private static Actividad selecionarProximaActividad(ArrayList<Actividad> actividades, Actividad ultimaActAgregada) {

//        long finMasProximo = -1;
        Actividad actividadAIncluir = null;
        Actividad comparativa = ultimaActAgregada;
        for (Actividad a :
                actividades) {
//            que termine antes y que no empiece antes que termine la ultima
            if (a.getFin() <= comparativa.getFin() && a.getIni() > ultimaActAgregada.getFin()) {
                comparativa = a;

            }
//            if (ultimaActAgregada.getFin() < a.getIni() && a.getFin() <= actividadAIncluir.getFin()) {
//            if (a.getFin() <= actividadAIncluir.getFin()) {

//                finMasProximo = a.getFin();
//                }
//            }
            if (!comparativa.equals(ultimaActAgregada)) {
                actividadAIncluir = comparativa;
            }
        }
        return actividadAIncluir;
    }

//tomo la siguiente actividad que termina antes
//la guardo en la lista
//busco la proxima que termine antes y que el inicio sea mayor al fin de la anterior
//Inicio ultima activadad: mayorCantActividades.get(mayorCantActividades.size()-1).getIni()

/*
     if (!mayorCantActividades.isEmpty()) {
                aux = selecionarProximaActividad(actividades, mayorCantActividades.get(mayorCantActividades.size()-1));
            } else {
                aux = selecionarProximaActividad(actividades, actividades.get(0));
            }
            if (aux != null)
            mayorCantActividades.add(aux);
            it.next();
 */