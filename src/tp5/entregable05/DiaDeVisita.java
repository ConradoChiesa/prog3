package tp5.entregable05;

import java.util.ArrayList;

public class DiaDeVisita {
    private int cupoPersonas;
    private int idDia;
    private int visitantes;
    private ArrayList<Familia> familias;

    public DiaDeVisita(int idDia) {
        this.familias = new ArrayList<>();
        this.cupoPersonas = 30;
        this.visitantes = 0;
        this.idDia = idDia;
    }

    public DiaDeVisita(int idDia, ArrayList<Familia> familias, int visitantes) {
        this.familias = familias;
        this.cupoPersonas = 30;
        this.visitantes = visitantes;
        this.idDia = idDia;
    }

    public int getIdDia() {
        return idDia;
    }


    public int getCupoPersonas() {
        return cupoPersonas;
    }

    public void setCupoPersonas(int cupoPersonas) {
        this.cupoPersonas = cupoPersonas;
    }

    public int getVisitantes() {
        return visitantes;
    }

    public void setVisitantes(int visitantes) {
        this.visitantes = visitantes;
    }

    public boolean agregarFamilia(Familia f) {
        boolean agregados = familias.add(f);
        if (agregados) {
            visitantes += f.miembros();
        }
        return agregados;
    }

    public boolean removeFamilia(Familia f) {
        boolean removed = familias.remove(f);
        if (removed) {
            visitantes -= f.miembros();
        }
        return removed;
    }

    public int lugaresDisponibles() {
        return cupoPersonas - visitantes;
    }

    public ArrayList<Familia> getFamilias() {
        return familias;
    }

    public boolean completo() {
        return cupoPersonas == visitantes;
    }

    @Override
    public String toString() {
        return "DiaDeVisita{" + idDia +
                " visitantes=" + visitantes +
                '}';
    }

}
