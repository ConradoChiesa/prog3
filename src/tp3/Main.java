package tp3;

public class Main {

	public static void main(String[] args) {

		// Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
		GrafoDirigido<Float> grafito = new GrafoDirigido<>();
		
		// Agrego los vertices 1 y 2
		grafito.agregarVertice(1);
		grafito.agregarVertice(2);
		grafito.agregarVertice(3);

		// Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
		grafito.agregarArco(1, 2, 3F);
		grafito.agregarArco(1, 3, 4F);
		grafito.agregarArco(1, 3, 5.23F);

		// Obtengo el arco entre 1 y 2, y le pido la etiqueta
		Float etiqueta = grafito.obtenerArco(1, 2).getEtiqueta();
		
		System.out.println(etiqueta); // Deber�a imprimir 3
		System.out.println(grafito.existeArco(1 ,3)); //Imprime TRUE
		System.out.println("La cantidad de arcos es: "+grafito.cantidadArcos());
		grafito.borrarArco(1,3); //El metodo imprime lo de esta linea se podría sacar
		System.out.println(grafito.existeArco(1 ,3)); //Imprime FALSE
		System.out.println("La cantidad de arcos es: "+grafito.cantidadArcos());
	}

}
