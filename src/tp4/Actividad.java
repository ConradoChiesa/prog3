package tp4;

import DDR_backracking.Elemento;

import java.util.Calendar;

public class Actividad implements Comparable{

    private Calendar start;

    private Calendar end;

    private long ini;

    private long fin;

    public Actividad(Calendar start, Calendar end) {
        this.start = start;
        this.end = end;
    }


    public Actividad(long ini, long fin) {
        this.ini = ini;
        this.fin = fin;
    }

    public Calendar getStart() {
        return start;
    }

    public void setStart(Calendar start) {
        this.start = start;
    }

    public Calendar getEnd() {
        return end;
    }

    public void setEnd(Calendar end) {
        this.end = end;
    }

    public long getIni() {
        return ini;
    }

    public void setIni(long ini) {
        this.ini = ini;
    }

    public long getFin() {
        return fin;
    }

    public void setFin(long fin) {
        this.fin = fin;
    }

    @Override
    public int compareTo(Object o) {
        return Long.compare(this.fin, ((Actividad) o).getFin());
//        return Long.compare(this.fin, ((Actividad) o).fin);
    }
// Reescribir para funcionalidad con Calendar
    @Override
    public String toString() {
        return
                "ini=" + ini +
                ", fin=" + fin;
    }
}
