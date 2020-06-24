package tp5.entregable05;

import java.util.ArrayList;
import java.util.Iterator;

import static tp5.entregable05.GlobalVar.DIAS_DE_APERTURA;
import static tp5.entregable05.GlobalVar.DIAS_PREFERIDOS;

public class TallerEspacial {

    private ArrayList<Familia> familiasVisitantes;

    private ArrayList<DiaDeVisita> diasDeVisita;
    private ArrayList<DiaDeVisita> diasDeVisitaMejor;
    private ArrayList<Familia> mejorDistribucionFlias;

    private int mejorBono;
    private int AUX = 0;

    public TallerEspacial(ArrayList<Familia> familiasVisitantes) {
        this.familiasVisitantes = familiasVisitantes;
        this.mejorDistribucionFlias = new ArrayList<>();
        this.diasDeVisitaMejor = new ArrayList<>();
        this.diasDeVisita = new ArrayList<>();
        for (int i = 0; i < DIAS_DE_APERTURA; i++) {
            diasDeVisita.add(new DiaDeVisita(i+1));
        }
        this.mejorBono = Integer.MAX_VALUE;
    }

    public Solucion distribuirFamilias() {
//        ArrayList<Familia> familias = new ArrayList<>();
//        if (!familiasVisitantes.isEmpty()) {
//            familias.add(familiasVisitantes.get(0));
            distribuirFamilias(0, 0);
//        }
//        calcularBono(diasDeVisitaMejor);
        return new Solucion(diasDeVisitaMejor, mejorBono);
    }

    private void distribuirFamilias(int bonoActual, int index) {
        if (bonoActual > mejorBono) return;
        if (index == familiasVisitantes.size()) {
            System.out.println("SOLUCIÓN"+ AUX++);

            if (bonoActual < mejorBono) {
                mejorBono = bonoActual;
                diasDeVisitaMejor.clear();
                diasDeVisitaMejor.addAll(diasDeVisita);
            }
        } else {
            Familia fliaActual = familiasVisitantes.get(index);
            Iterator<Integer> itDiasPreferidos = fliaActual.itDiasPreferidos();
            while (itDiasPreferidos.hasNext()) {
                int diaSeleccionado = itDiasPreferidos.next();
                if (diasDeVisita.get(diaSeleccionado-1).lugaresDisponibles() >= fliaActual.miembros()) {
                    adjudicarDiaA(fliaActual, diaSeleccionado);
                    fliaActual.setDiaAsignado(diaSeleccionado);
                    index++;
                    bonoActual += calcularBonoFlia(fliaActual);
                    distribuirFamilias(bonoActual, index);
//                    distribuirFamilias(calcularBono(diasDeVisita), index);
                    bonoActual -= calcularBonoFlia(fliaActual);
                    quitarFamilia(fliaActual);
                    fliaActual.setDiaAsignado(0);
                    index--;
                }
            }
        }
    }

    private boolean quitarFamilia(Familia fliaActual) {
        return diasDeVisita.get(fliaActual.getDiaAsignado()-1).removeFamilia(fliaActual);
    }

    private boolean adjudicarDiaA(Familia fliaActual, int dia) {
// Es evaluado antes de ser llamado no tenía mucho sentido
//        if (diasDeVisita.get(dia-1).lugaresDisponibles() >= fliaActual.miembros()) {
            fliaActual.setDiaAsignado(fliaActual.preferenciaEn(fliaActual.indiceDePreferencia(dia)));
            return diasDeVisita.get(dia-1).agregarFamilia(fliaActual);
//        }
//        return false;
    }

    private int calcularBono(ArrayList<DiaDeVisita> diasDeVisita) {
        int bono = 0;
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
        return bono;
    }

    private int calcularBonoFlia(Familia flia) {
        if (flia.indiceDePreferencia(flia.getDiaAsignado()) == 0) {
            return 0;
        } else {
            return 25 + (10 * flia.miembros()) + (5 * flia.indiceDePreferencia(flia.indiceDePreferencia(flia.getDiaAsignado())));
        }
    }
}
/*
} else {
            Iterator<Familia> itFlias = familiasVisitantes.iterator();
            while (itFlias.hasNext()) {
                    Familia fliaActual = itFlias.next();

//                if (fliaActual.getDiaAsignado() == 0) {
                if (!familias.contains(fliaActual)) {
                    Iterator<Integer> itDiasPreferidos = fliaActual.itDiasPreferidos();
                    if (!adjudicarDiaA(fliaActual, itDiasPreferidos.next())) return;
//                    System.out.println("La flia " + fliaActual.getId() + " asignada: " + familias.add(fliaActual));
                    familias.add(fliaActual);
                    distribuirFamilias(familias, calcularBono(diasDeVisita));
//                    System.out.println("La flia " + fliaActual.getId() + " borrada: " + quitarFamilia(fliaActual));
                    quitarFamilia(fliaActual);
                    familias.remove(familias.size() - 1);
                }
            }

        }
 */