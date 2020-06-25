package tp5.entregable05;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	
	public static void main(String... args) {

		CSVReader reader = new CSVReader("/home/konrad/Documentos/prog3/src/tp5/entregable05/familias-1.csv");
		
		ArrayList<Familia> familias = reader.read();
		TallerEspacial te1 = new TallerEspacial();

		System.out.print("\n");
		System.out.println("Procesando DATASET 1");
		Solucion s1 = te1.distribuirFamilias(familias);
		System.out.println("Estados visitados: " + s1.getEstadosVisitados());
		System.out.println("El bono es de U$S" + s1.getBono());
		System.out.println(s1.getDiasDeVisita().toString());
		CSVReader reader2 = new CSVReader("/home/konrad/Documentos/prog3/src/tp5/entregable05//familias-2.csv");

		ArrayList<Familia> familias2 = reader2.read();
		TallerEspacial te2 = new TallerEspacial();

		System.out.print("\n");
		System.out.println("Procesando DATASET 2");
		Solucion s2 = te2.distribuirFamilias(familias2);
		System.out.println("Estados visitados: " + s2.getEstadosVisitados());
		System.out.println("El bono es de U$S" + s2.getBono());
		System.out.println(s2.getDiasDeVisita().toString());
	}
}
