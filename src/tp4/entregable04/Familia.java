package tp4.entregable04;

import java.util.Arrays;

import static tp5.entregable05.GlobalVar.DIAS_PREFERIDOS;

/* Una familia, con su cantidad de dias, y una arreglo con el top de 4 dias preferidos */
public class Familia implements Comparable {

	private int id;
	private int miembros;
	private int diaAsignado;
	private int[] diasPreferidos;


	public Familia() {
		this.id = 0;
		this.miembros = 0;
		this.diasPreferidos = new int[DIAS_PREFERIDOS];
		this.diaAsignado = 0;

	}

	public int getDiaAsignado() {
		return diaAsignado;
	}

	public void setDiaAsignado(int diaAsignado) {
		this.diaAsignado = diaAsignado;
	}
	public Familia(int id, int miembros, int... diasPreferidos) {
		this.id = id;
		this.miembros = miembros;
		this.diasPreferidos = diasPreferidos;
		this.diaAsignado = 0;
	}

	/* Id de la familia */
	public int getId() {
		return id;
	}


	/* Retorna la cantidad de miembros de la familia. */
	public int miembros() {
		return miembros;
	}

	
	/* Dado un indice entre 0 y 4, retorna el d�a preferido por la familia para ese indice. */
	public int preferenciaEn(int indice) {
		return this.diasPreferidos[indice];
	}
	
	/* Retorna el d�a preferido de la familia */
	public int diaPreferido() {
		return preferenciaEn(0);
	}
	
	/* Dado un dia pasado por parametro, indica el orden de ese dia en el top 5 de preferencias.
	Si el dia no forma parte de las preferencias del usuario, se retorna -1. */ 
	public int indiceDePreferencia(int dia) {
		for (int indice = 0; indice < diasPreferidos.length; indice++)
			if (dia == diasPreferidos[indice])
				return indice;
		return -1;
	}

	@Override
	public String toString() {
		return "Familia: id=" + id + ", miembros=" + miembros + ", preferencias=" + Arrays.toString(diasPreferidos) +" Asignado: " + diaAsignado + "\n";
	}

	@Override
	public int compareTo(Object o) {
		return Integer.compare(this.miembros(), ((Familia) o).miembros());
	}
}
