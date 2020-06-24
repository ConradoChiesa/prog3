package tp5.entregable05;

import tp3.Arco;

import java.util.Arrays;
import java.util.Iterator;

/* Una familia, con su cantidad de dias, y una arreglo con el top de 3 dias preferidos */
public class Familia implements Comparable<Familia> {

	private int id;
	private int miembros;
	private int[] diasPreferidos;
	private int diaAsignado;


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

	
	/* Dado un indice entre 0 y 2, retorna el d�a preferido por la familia para ese indice. */
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

	public int getDiaAsignado() {
		return diaAsignado;
	}

	public void setDiaAsignado(int diaAsignado) {
		this.diaAsignado = diaAsignado;
	}

	public Iterator<Integer> itDiasPreferidos() {

		Iterator<Integer> it = new Iterator() {
			private int index = 0;
			@Override
			public boolean hasNext() {
				return index < diasPreferidos.length && diasPreferidos[index] != 0;
			}
//          Devuelve el día preferido
			@Override
			public Integer next() {
				return diasPreferidos[index++];
			}
		};
		return it;

	}

	@Override
	public String toString() {
		return "Familia: id=" + id + ", miembros=" + miembros + ", preferencias=" + Arrays.toString(diasPreferidos);
	}

	@Override
	public int compareTo(Familia o) {
		return Integer.compare(this.miembros, o.miembros);
	}

}
