package tp4.entregable04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import static tp4.entregable04.GlobalVar.*;

public class TallerEspacial {


    private ArrayList<Familia> familiasVisitantes;

    private ArrayList<DiaDeVisita> diasDeVisita;

    public TallerEspacial(ArrayList<Familia> familiasVisitantes) {
        this.familiasVisitantes = familiasVisitantes;
        this.diasDeVisita = new ArrayList<>(DIAS_DE_APERTURA);
        for (int i = 0; i < DIAS_DE_APERTURA; i++) {
            diasDeVisita.add(new DiaDeVisita());
        }
    }

    public void distribuirFamilias () {
        ArrayList<Familia> copiaFamVis = new ArrayList<>(this.familiasVisitantes);
        int bono = 0;
        // Ordenamiento por cantidad de miembros
        Collections.sort(copiaFamVis);
//        Collections.reverse(copiaFamVis);
//        System.out.println(copiaFamVis.toString());
        Iterator<Familia> itFamilia = copiaFamVis.iterator();
        while (itFamilia.hasNext()) {
            Familia actual = itFamilia.next();
            if (actual.miembros() < diasDeVisita.get(actual.diaPreferido()-1).lugaresDisponibles()) {
                diasDeVisita.get(actual.diaPreferido()-1).agregarVisitantes(actual.miembros());
                itFamilia.remove();
            }
        }

        if (!copiaFamVis.isEmpty()) {
            itFamilia = copiaFamVis.iterator();
            boolean agregada = false;
            while (itFamilia.hasNext()) {
                Familia actual = itFamilia.next();
                for (int i = 1; i < DIAS_PREFERIDOS; i++) {
                    if (diasDeVisita.get(actual.preferenciaEn(i)-1).lugaresDisponibles() >= actual.miembros()) {
                        agregada = diasDeVisita.get(actual.preferenciaEn(i)-1).agregarVisitantes(actual.miembros());
                        bono += 25 + (10 * actual.miembros()) + (5 * i);
                        break;
                    }
                }
                if (agregada) {
                    itFamilia.remove();
                    agregada = false;
                }
            }
        }

        System.out.println("Arreglo de familias qeu quedaron sin día asignado " + copiaFamVis.toString());

        System.out.println("El costo en bonos es de U$S " + bono);

    }
}
