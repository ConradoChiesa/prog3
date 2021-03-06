package tp4.entregable04;

import java.util.ArrayList;

public class Main {

	
	public static void main(String... args) {
		
		
		CSVReader reader = new CSVReader("/home/konrad/Documentos/prog3/src/tp4/entregable04/familias.csv");
		
		ArrayList<Familia> familias = reader.read();
		TallerEspacial te = new TallerEspacial(familias);

		Solucion s = te.distribuirFamilias2();
		System.out.println("El bono es de U$S" + s.getBono());
		System.out.println(s.getDiasDeVisita());
		/*
		for (Familia familia: familias)
			System.out.println(familia);
		*/
	}
}
