package tp3;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		// Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
		GrafoDirigido<Integer> grafito = new GrafoDirigido<>();
		secuenciaEjecucionCritica GDT = new secuenciaEjecucionCritica(grafito);

		// Agrego los vertices 1 y 2
		grafito.agregarVertice(0);
		grafito.agregarVertice(1);
		grafito.agregarVertice(2);
		grafito.agregarVertice(3);
		grafito.agregarVertice(4);
		grafito.agregarVertice(5);
		grafito.agregarVertice(6);
		grafito.agregarVertice(7);
		grafito.agregarVertice(8);
		grafito.agregarVertice(9);
		grafito.agregarVertice(10);
		grafito.agregarVertice(11);
		grafito.agregarVertice(12);

		// Agregando tareas
		Tarea t0 = new Tarea("tarea0", "Tarea Inicial", 0);
		Tarea t1 = new Tarea("tarea1", "Primer tarea", 4);
		Tarea t2 = new Tarea("tarea2", "Primer tarea", 18);
		Tarea t3 = new Tarea("tarea3", "Segunda tarea", 4);
		Tarea t4 = new Tarea("tarea4", "Tercer tarea", 13);
		Tarea t5 = new Tarea("tarea5", "Tercer tarea", 22);
		Tarea t6 = new Tarea("tarea6", "Cuarta tarea", 18);
		Tarea t7 = new Tarea("tarea7", "Cuarta tarea", 12);
		Tarea t8 = new Tarea("tarea8", "Quinta tarea", 3);
		Tarea t9 = new Tarea("tarea9", "Quinta tarea", 2);
		Tarea t10 = new Tarea("tarea10", "Sexta tarea", 3);
		Tarea t11 = new Tarea("tarea11", "Sexta tarea", 1);
		Tarea t12 = new Tarea("tarea12", "Sexta tarea", 5);

		//Agrego las tareas a los respectivos vertices
		GDT.agregarTarea(t0,0);
		GDT.agregarTarea(t1,1);
		GDT.agregarTarea(t2,2);
		GDT.agregarTarea(t3,3);
		GDT.agregarTarea(t4,4);
		GDT.agregarTarea(t5,5);
		GDT.agregarTarea(t6,6);
		GDT.agregarTarea(t7,7);
		GDT.agregarTarea(t8,8);
		GDT.agregarTarea(t9,9);
		GDT.agregarTarea(t10,10);
		GDT.agregarTarea(t11,11);
		GDT.agregarTarea(t12,12);

		// Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
/*
		grafito.agregarArco(1, 1, 3F);
		grafito.agregarArco(1, 2, 4F);
		grafito.agregarArco(2, 3, 5.23F);
		grafito.agregarArco(3, 1, 2.98F);
		grafito.agregarArco(3, 2, 5.56F);
		grafito.agregarArco(3, 4, 6.52F);
		grafito.agregarArco(5, 2, 3F);
*/


		grafito.agregarArco(0, 1, 0);
		grafito.agregarArco(0, 2, 0);
		grafito.agregarArco(1, 3, 3);
		grafito.agregarArco(2, 5, 1);
		grafito.agregarArco(2, 7, 18);
		grafito.agregarArco(3, 4, 5);
		grafito.agregarArco(3, 6, 8);
		grafito.agregarArco(4, 11, 3);
		grafito.agregarArco(5, 6, 2);
		grafito.agregarArco(6, 10, 6);
		grafito.agregarArco(6, 12, 2);
		grafito.agregarArco(7, 8, 7);
		grafito.agregarArco(8, 9, 4);
		grafito.agregarArco(9, 10, 1);
		grafito.agregarArco(11, 12, 9);

		// Obtengo el arco entre 1 y 2, y le pido la etiqueta
//		Float etiqueta = grafito.obtenerArco(1, 2).getEtiqueta();

//		Integer etiGDT = (Integer) GDT.obtenerArco(3,2).getEtiqueta();
//		System.out.println("Valor etiqueta GDT " + etiGDT);
//		System.out.println(etiqueta); // Deber�a imprimir 3
//		System.out.println(grafito.existeArco(1 ,3)); //Imprime TRUE
//		System.out.println("La cantidad de arcos es: "+grafito.cantidadArcos());
//		grafito.borrarArco(1,3); //El metodo imprime lo de esta linea se podría sacar
//		System.out.println(grafito.existeArco(1 ,3)); //Imprime FALSE
//		System.out.println("La cantidad de arcos es: "+grafito.cantidadArcos());
//		grafito.borrarVertice(3);
//		System.out.println("La cantidad de arcos es: "+grafito.cantidadArcos());
//		System.out.println(grafito.existeArco(2,3));
		System.out.println("La cantidad de arcos es: "+grafito.cantidadArcos());
//		System.out.println(grafito.indiceTareas.toString());
//		System.out.println(GDT.indiceTareas.get(3).toString());
		ArrayList<Integer> sec = new ArrayList<>();
		sec.addAll(GDT.secuenciaEjecucionCritica(0));
		System.out.println(sec.toString());
//		System.out.println(GDT.secuenciaEjecucionCritica(0));
//		System.out.println(GDT.secuenciaEjecucionCritica(0).size());
	}

}
