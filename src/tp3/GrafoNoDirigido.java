package tp3;

public class GrafoNoDirigido<T> extends GrafoDirigido<T> {

	@Override
	public boolean agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		super.agregarArco(verticeId1, verticeId2, etiqueta);
		 return super.agregarArco(verticeId2, verticeId1, etiqueta);
	}
	
	@Override
	public boolean borrarArco(int verticeId1, int verticeId2) {
		super.borrarArco(verticeId1, verticeId2);
		return super.borrarArco(verticeId2, verticeId1);
	}

}
