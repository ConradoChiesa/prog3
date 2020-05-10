package tp3;

import java.util.ArrayList;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

	private ArrayList<Vertice> vertices;

	public GrafoDirigido() {
		vertices = new ArrayList<>();
	}

	private int getIndex(Vertice v) {
		return vertices.indexOf(v);
	}

	@Override
	public void agregarVertice(int verticeId) {
		// TODO Auto-generated method stub
		Vertice v = new Vertice(verticeId);
		if (!vertices.contains(v)) {
			vertices.add(v);
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		// TODO Auto-generated method stub
		Vertice v = new Vertice(verticeId);
//		hacer cosas acá no es borrar así nomas
		vertices.remove(v);
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		// TODO Auto-generated method stub
		Vertice v1 = new Vertice(verticeId1);
		Vertice v2 = new Vertice(verticeId2);
		if (vertices.contains(v1) && vertices.contains(v2)) {
			if (!existeArco(verticeId1, verticeId2)) {
				Arco a = new Arco(verticeId1, verticeId2, etiqueta);
				Vertice current = vertices.get(getIndex(v1));
				current.setArcos(a);
			}
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		Vertice current = new Vertice(verticeId1);
		current = vertices.get(getIndex(current));
		Arco a = new Arco(verticeId1, verticeId2, null);
		if (current.delete(a)) {
			System.out.println("Arco borrado");
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		// TODO Auto-generated method stub
		Vertice current = new Vertice(verticeId);
		return vertices.contains(current);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		Vertice v1 = new Vertice(verticeId1);
		int index = getIndex(v1);
		v1 = vertices.get(index);
		Iterator<Arco> it = v1.getArcos().iterator();
		while (it.hasNext()) {
			if (it.next().getVerticeDestino()==verticeId2) {
				return true;
			}
		}
		return false;
	}
// Devuelve la ultima que tenga los 2 vertices, esta mal? no debería agregar 2 arcos a 2 mismos vertices
	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		Vertice current = new Vertice(verticeId1);
		Arco aux = new Arco();
		if (vertices.contains(current) && vertices.contains(new Vertice(verticeId2))) {
			int index = getIndex(current);
			Vertice v = vertices.get(index);
			Iterator<Arco> it = v.getArcos().iterator();
			while (it.hasNext()) {
				Arco a = it.next();
				if (a.getVerticeOrigen()==verticeId1 && a.getVerticeDestino() == verticeId2) {
					aux = a;
				}

			}
		}
		return aux;
	}

	@Override
	public int cantidadVertices() {
		// TODO Auto-generated method stub
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		// TODO Auto-generated method stub
		int sum = 0;
		Iterator<Vertice> it = vertices.iterator();
		while (it.hasNext()) {
			sum += it.next().getArcos().size();
		}
		return sum;
	}
// No me queda claro si hay que iterar los vertices o los valores de los mismos, pero el iterador solicitado es de integer
	@Override
	public Iterator<Integer> obtenerVertices() {
		// TODO Auto-generated method stub
		Iterator<Integer> it = new Iterator<Integer>() {
			private int index = 0;
			@Override
			public boolean hasNext() {
				return index < vertices.size() && vertices.get(index) != null;
			}

			@Override
			public Integer next() {
				return vertices.get(index++).getValor();
			}
		};
		return it;
	}
// tengo dudas con este metodo
	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		Vertice current = new Vertice(verticeId);
		current = vertices.get(getIndex(current));
		Vertice finalCurrent = current; // acá
		Iterator<Integer> it = new Iterator<Integer>() {
			private int index = 0;
			@Override
			public boolean hasNext() {
				return index < finalCurrent.getArcos().size() && finalCurrent.getArcos().get(index) != null;
			}

			@Override
			public Integer next() {// acá
				Arco a = (Arco) finalCurrent.getArcos().get(index++);
				return a.getVerticeDestino();
			}
		};
		return it;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		ArrayList<Arco<T>> aux = new ArrayList<>();
		for (Vertice v :
				vertices) {
			aux.addAll(v.getArcos());
		}
		return aux.iterator();
/*
		Iterator<Arco<T>> it = new Iterator<Arco<T>>() {
			private int indexVertice = 0;
			private int indexArco = 0;

			@Override
			public boolean hasNext() {
				return indexVertice < vertices.size() && vertices.get(indexVertice) != null;
			}

			@Override
			public Arco next() {
				Arco a = new Arco();
				if (indexArco < vertices.get(indexVertice).getArcos().size()) {
					a = (Arco) vertices.get(indexVertice).getArcos().get(indexArco++);
				} else {
					indexVertice++;
					indexArco = 0;
				}
				return a;
			}
		};
		return it;
*/
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		Vertice current = new Vertice(verticeId);
		current = vertices.get(getIndex(current));
		Iterator curre = current.getArcos().iterator();
		return curre;
	}

}