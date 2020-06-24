package tp4.entregable04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import static tp5.entregable05.GlobalVar.*;

public class TallerEspacial {


    private ArrayList<Familia> familiasVisitantes;

    private ArrayList<DiaDeVisita> diasDeVisita;

    private int bono;

    public TallerEspacial(ArrayList<Familia> familiasVisitantes) {
        this.bono = 0;
        this.familiasVisitantes = familiasVisitantes;
        this.diasDeVisita = new ArrayList<>(DIAS_DE_APERTURA);
        for (int i = 0; i < DIAS_DE_APERTURA; i++) {
            diasDeVisita.add(new DiaDeVisita(i+1));
        }
    }

    @Deprecated
    public Solucion distribuirFamilias() {
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
                diasDeVisita.get(actual.diaPreferido()-1).agregarFamilia(actual);
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
                        agregada = diasDeVisita.get(actual.preferenciaEn(i)-1).agregarFamilia(actual);
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
        return new Solucion(diasDeVisita, bono);
    }


    // Otro enfoque del algoritmo según quinta aproximación del informe adjunto
    public Solucion distribuirFamilias2() {
        ArrayList<Familia> familiasSinAsignar = new ArrayList<>();
        // Ordenamiento por cantidad de miembros
        Collections.sort(familiasVisitantes);
//        Collections.reverse(familiasVisitantes);
        Iterator<Familia> itFamilia = familiasVisitantes.iterator();
        while (itFamilia.hasNext()) {
            Familia actual = itFamilia.next();


            if (actual.miembros() <= diasDeVisita.get(actual.diaPreferido()-1).lugaresDisponibles()) {
                diasDeVisita.get(actual.diaPreferido()-1).agregarFamilia(actual);
                actual.setDiaAsignado(diasDeVisita.get(actual.diaPreferido()-1).getIdDia());
//                System.out.println(actual.getDiaAsignado());
            } else {
                familiasSinAsignar.add(actual);
//                System.out.println("La familia " + actual.getId() + " no pudo ser asignada el día " + actual.diaPreferido());
            }
        }

        if (!familiasSinAsignar.isEmpty()) {
            itFamilia = familiasSinAsignar.iterator();
            while (itFamilia.hasNext()) {
                Familia actual = itFamilia.next();
                if (asignarFlia(actual)) {
                    itFamilia.remove();
                } else {
                    System.out.println("No se ha agregado a la familia " + actual.getId());
                }
            }
        }
        calcularBono();
        System.out.println("EL bono sin mejora: U$S"+ bono);

// Tratando de mejorar la solución
        ArrayList<Familia> familiasReasignar = new ArrayList<>();
        Iterator<DiaDeVisita> it = diasDeVisita.iterator();
        while (it.hasNext()) {
            DiaDeVisita ddv = it.next();
            ArrayList<Familia> familiasDelDia = ddv.getFamilias();
            Iterator<Familia> itFamiliasDelDia = familiasDelDia.iterator();
            while (itFamiliasDelDia.hasNext()) {
                Familia actual = itFamiliasDelDia.next();
                if (actual.indiceDePreferencia(diasDeVisita.indexOf(ddv)+1) > 3) {
                    familiasReasignar.add(actual);
                }
            }
        }// hasta acá bien
//        System.out.println(familiasReasignar.toString());
        Iterator<Familia> reasignar = familiasReasignar.iterator();
        while (reasignar.hasNext()) {
            Familia actual = reasignar.next();
            DiaDeVisita diaPreferidoFliaActual = diasDeVisita.get(actual.diaPreferido()-1);
            if (diaPreferidoFliaActual.lugaresDisponibles() >= actual.miembros()) {
//                System.out.println(actual.diaPreferido());
                diasDeVisita.get(actual.getDiaAsignado()-1).removeFamilia(actual);
                diasDeVisita.get(actual.diaPreferido()-1).agregarFamilia(actual);
                actual.setDiaAsignado(actual.diaPreferido());
            } else {
                ArrayList<Familia> aux = diasDeVisita.get(diaPreferidoFliaActual.getIdDia()-1).getFamilias();// esto trae mal
//                System.out.println("array de dia a reasignar" + aux.toString());
                Familia intercambio = aux.get(aux.size()-1);
                System.out.println(intercambio.getId()+ " id familia a intercambio");
                int espacaioGenerado = diasDeVisita.get(diaPreferidoFliaActual.getIdDia()-1).lugaresDisponibles() + intercambio.miembros();
                System.out.println("Espacio generado: " + espacaioGenerado);
                if (actual.miembros() <= espacaioGenerado && consigueLugar(intercambio)) {
                    diasDeVisita.get(intercambio.getDiaAsignado()-1).removeFamilia(intercambio);
                    diasDeVisita.get(actual.getDiaAsignado()-1).removeFamilia(actual);
//                    diasDeVisita.get(actual.diaPreferido()).agregarFamilia(actual);
//                    actual.setDiaAsignado(actual.diaPreferido());
                    asignarFlia(actual);
                    asignarFlia(intercambio);
                }
            }
        }
        System.out.println("Familias a reasignar " + familiasReasignar.size());
        calcularBono();
        cantidadFamiliasAsignadas();
        return new Solucion(diasDeVisita, bono);
    }

    private boolean consigueLugar(Familia intercambio) {
        for (int i = 0; i < DIAS_PREFERIDOS; i++) {
            if (diasDeVisita.get(intercambio.preferenciaEn(i)-1).lugaresDisponibles() >= intercambio.miembros()) {
                System.out.println("La familia " + intercambio.getId() + " consigue lugar el día " + intercambio.preferenciaEn(i));
                return true;
            }
        }
        return false;
    }

    private boolean asignarFlia(Familia familiaSinAsignar) {
        boolean agregada = false;
        for (int i = 0; i < DIAS_PREFERIDOS; i++) {
            if (diasDeVisita.get(familiaSinAsignar.preferenciaEn(i)-1).lugaresDisponibles() >= familiaSinAsignar.miembros()) {
                agregada = diasDeVisita.get(familiaSinAsignar.preferenciaEn(i)-1).agregarFamilia(familiaSinAsignar);
                familiaSinAsignar.setDiaAsignado(familiaSinAsignar.preferenciaEn(i));
                break;
            }
        }
        return agregada;
    }

    private void calcularBono() {
        bono = 0;
        Iterator<DiaDeVisita> bonosDias = diasDeVisita.iterator();
        while (bonosDias.hasNext()) {
            DiaDeVisita d = bonosDias.next();
            Iterator<Familia> bonosFamilia = d.getFamilias().iterator();
            while (bonosFamilia.hasNext()) {
                Familia f = bonosFamilia.next();
                if (f.diaPreferido() != diasDeVisita.indexOf(d)+1) {
                    bono += 25 + (10 * f.miembros()) + (5 * f.indiceDePreferencia(diasDeVisita.indexOf(d)+1));
                }
            }
        }
    }

    private void cantidadFamiliasAsignadas() {
        int aux = 0;
        for (DiaDeVisita d :
                diasDeVisita) {
            aux += d.getFamilias().size();
        }
        System.out.println("Se asignaron "+ aux);
    }
}
