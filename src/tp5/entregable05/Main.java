package tp5.entregable05;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	
	public static void main(String... args) {
		
		
		CSVReader reader = new CSVReader("/home/konrad/Documentos/prog3/src/tp5/entregable05/familias-2.csv");
		
		ArrayList<Familia> familias = reader.read();
		TallerEspacial te = new TallerEspacial(familias);

		Solucion s = te.distribuirFamilias();
		System.out.println("El bono es de U$S" + s.getBono());
		System.out.println(s.getDiasDeVisita().toString());
/*
		Iterator it = familias.get(0).itDiasPreferidos();
		while (it.hasNext()) {
			System.out.print("Dia: "+ it.next());
		}
*/

/*

		for (Familia familia: familias)
			System.out.println(familia);


		CSVReader reader2 = new CSVReader("/home/konrad/Documentos/prog3/src/tp5/entregable05//familias-2.csv");
		
		ArrayList<Familia> familias2 = reader2.read();

		for (Familia familia: familias2)
			System.out.println(familia);
*/

	}
}
