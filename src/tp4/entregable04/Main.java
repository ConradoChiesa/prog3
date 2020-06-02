package tp4.entregable04;

import java.util.ArrayList;

public class Main {

	
	public static void main(String... args) {
		
		
		CSVReader reader = new CSVReader("/home/konrad/Documentos/prog3/src/tp4/entregable04/familias.csv");
		
		ArrayList<Familia> familias = reader.read();
		TallerEspacial te = new TallerEspacial(familias);
		te.distribuirFamilias();
		/*
		for (Familia familia: familias)
			System.out.println(familia);
		*/
	}
}
