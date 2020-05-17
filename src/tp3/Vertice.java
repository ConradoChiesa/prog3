package tp3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertice<T> {

    private int valor;
    private List<Arco<T>> arcos;

    public Vertice(int valor) {
        this.valor = valor;
        arcos = new ArrayList<>();
    }

    public List<Arco<T>> getArcos() {
        return arcos;
    }

    public boolean setArcos(Arco a) {
        return this.arcos.add(a);
    }

    public boolean delete(Arco a) {
        return arcos.remove(a);
    }

    public int getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice<?> vertice = (Vertice<?>) o;
        return valor == vertice.valor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

}
