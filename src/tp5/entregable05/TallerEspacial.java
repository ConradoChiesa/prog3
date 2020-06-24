package tp5.entregable05;

import java.util.ArrayList;
import java.util.Iterator;

import static tp5.entregable05.GlobalVar.DIAS_DE_APERTURA;

public class TallerEspacial {

    private ArrayList<Familia> familiasVisitantes;
    private ArrayList<DiaDeVisita> diasDeVisita;
    private ArrayList<DiaDeVisita> diasDeVisitaMejor;
    private int mejorBono;

    public TallerEspacial(ArrayList<Familia> familiasVisitantes) {
        this.familiasVisitantes = familiasVisitantes;
        this.diasDeVisitaMejor = new ArrayList<>();
        this.diasDeVisita = new ArrayList<>();
        for (int i = 0; i < DIAS_DE_APERTURA; i++) {
            diasDeVisita.add(new DiaDeVisita(i+1));
        }
        this.mejorBono = Integer.MAX_VALUE;
    }

    public Solucion distribuirFamilias() {
        distribuirFamilias(0, 0);
        return new Solucion(diasDeVisitaMejor, mejorBono);
    }

    private void distribuirFamilias(int bonoActual, int index) {
        if (bonoActual > mejorBono) return;
        if (index == familiasVisitantes.size()) {
            if (bonoActual < mejorBono) {
                mejorBono = bonoActual;
                diasDeVisitaMejor.clear();
                for (DiaDeVisita dia : diasDeVisita)
                    diasDeVisitaMejor.add(new DiaDeVisita(dia.getIdDia(), dia.getFamilias(), dia.getVisitantes()));
            }
        } else {
            Familia fliaActual = familiasVisitantes.get(index);
            Iterator<Integer> itDiasPreferidos = fliaActual.itDiasPreferidos();
            while (itDiasPreferidos.hasNext()) {
                int diaSeleccionado = itDiasPreferidos.next();
                if (diasDeVisita.get(diaSeleccionado-1).lugaresDisponibles() >= fliaActual.miembros()) {
                    adjudicarDiaA(fliaActual, diaSeleccionado);
                    index++;
                    bonoActual += calcularBonoFlia(fliaActual);
                    distribuirFamilias(bonoActual, index);
                    bonoActual -= calcularBonoFlia(fliaActual);
                    quitarFamilia(fliaActual);
                    index--;
                }
            }
        }
    }

    private boolean quitarFamilia(Familia fliaActual) {
        if (diasDeVisita.get(fliaActual.getDiaAsignado()-1).removeFamilia(fliaActual))
            fliaActual.setDiaAsignado(0);
        return fliaActual.getDiaAsignado() == 0;
    }

    private boolean adjudicarDiaA(Familia fliaActual, int dia) {
            fliaActual.setDiaAsignado(fliaActual.preferenciaEn(fliaActual.indiceDePreferencia(dia)));
            return diasDeVisita.get(dia-1).agregarFamilia(fliaActual);
    }

    private int calcularBonoFlia(Familia flia) {
        return flia.indiceDePreferencia(flia.getDiaAsignado()) == 0 ? 0
                : 25 + (10 * flia.miembros()) + (5 * flia.indiceDePreferencia(flia.getDiaAsignado()));
    }
}