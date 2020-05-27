package DDR_backracking;

import java.util.Arrays;

public class Mochila {

    private double pesoMaximo;
    private Elemento [] elementos;

    private double peso;
    private double beneficio;

    public Mochila(double pesoMaximo, int numElementos) {
        this.pesoMaximo = pesoMaximo;
        this.elementos = new Elemento[numElementos];
        this.peso = 0;
        this.beneficio = 0;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
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

    public void addElemento(Elemento e) {
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] == null) {
                this.elementos[i] = e;
                this.beneficio += e.getBeneficio();
                this.peso += e.getPeso();
                break;
            }
        }
    }

    public void clear() {
        this.peso = 0;
        this.beneficio = 0;
        for (int i = 0; i < this.elementos.length; i++) {
            this.elementos[i] = null;
        }
    }

    public void eliminarElemento(Elemento e) {
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i].equals(e)) {
                this.elementos[i] = null;
                this.beneficio -= e.getBeneficio();
                this.peso -= e.getPeso();
                break;
            }
        }
    }

    public Elemento[] getElementos() {
        return elementos;
    }

    public boolean existeElemento(Elemento e) {
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] != null && this.elementos[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public double pesoDisponible() {
        return this.pesoMaximo - this.peso;
    }

    @Override
    public String toString() {
        String cadena = "";
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] != null) {
                cadena += elementos[i]+"\n";
            }
        }
        cadena +="Peso: " + getPeso()+"\n";
        cadena += "Beneficio: "+ getBeneficio()+"\n";
        return cadena;
    }

}
