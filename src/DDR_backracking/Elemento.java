package DDR_backracking;

import java.util.Objects;

public class Elemento implements Comparable{

    private double peso;

    private double beneficio;

    private double valorPorPeso;

    public Elemento(double peso, double beneficio) {
        this.peso = peso;
        this.beneficio = beneficio;
        this.valorPorPeso = beneficio / peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }

    public double getValorPorPeso() {
        return valorPorPeso;
    }

    public void setValorPorPeso(float valorPorPeso) {
        this.valorPorPeso = valorPorPeso;
    }

    @Override
    public String toString() {
        return "Peso=" + peso +
                ", beneficio=" + beneficio +
                ", Valor por peso=" + valorPorPeso +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elemento elemento = (Elemento) o;
        return peso == elemento.peso &&
                beneficio == elemento.beneficio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(peso, beneficio);
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(this.valorPorPeso, ((Elemento) o).getValorPorPeso());
    }
}
