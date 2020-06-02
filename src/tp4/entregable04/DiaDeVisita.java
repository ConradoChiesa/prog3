package tp4.entregable04;

public class DiaDeVisita {
    private int cupoPersonas; //final static ???

    private int visitantes;

    public DiaDeVisita() {
        this.cupoPersonas = 340;
        this.visitantes = 0;
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

    public boolean agregarVisitantes(int visitantes) {
        boolean agregados = false;
        if (visitantes <= lugaresDisponibles()) {
            this.visitantes += visitantes;
            agregados = true;
        }
        return agregados;
    }

    public int lugaresDisponibles() {
        return cupoPersonas - visitantes;
    }

    public boolean completo() {
        return cupoPersonas == visitantes;
    }

    @Override
    public String toString() {
        return "DiaDeVisita{" +
                "visitantes=" + visitantes +
                '}';
    }
}
