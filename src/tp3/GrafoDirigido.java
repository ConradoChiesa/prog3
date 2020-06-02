package tp3;

import java.util.ArrayList;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

	private ArrayList<Vertice> vertices;

	public GrafoDirigido() {
		vertices = new ArrayList<>();
	}
// O(vertices.size() En el peor de los casos va a buscar hasta en el utlimo elemento
	private int getIndex(Vertice v) {
		return vertices.indexOf(v);
	}

// O(vertices.size()) Va a buscar en todas las posiciones y si no lo contiene lo agrega al final
	@Override
	public boolean agregarVertice(int verticeId) {
		// TODO Auto-generated method stub
		boolean added = false;
		Vertice v = new Vertice(verticeId);
		if (!vertices.contains(v)) {
			added = vertices.add(v);
		}
		return added;
	}

// O(vertices.size() + total de arcos) va a recorrer tod slos vertices y preguntar a todos los arcos de cada
// vertice si tiene como destino el vertice que se desea borrar borrar
	@Override
	public boolean borrarVertice(int verticeId) {
		// TODO Auto-generated method stub
		if (contieneVertice(verticeId)) {
			Vertice verticeToDelete = vertices.get(getIndex(new Vertice(verticeId)));
			ArrayList<Arco> arcos = new ArrayList<>();
			Iterator<Vertice> verticeIterator = vertices.iterator();
			while (verticeIterator.hasNext()) {
				Vertice current = verticeIterator.next();
				arcos.addAll(current.getArcos());
				Iterator<Arco> arcoIterator = arcos.iterator();
				while (arcoIterator.hasNext()) {
					if (arcoIterator.next().getVerticeDestino() == verticeId) {
						System.out.println("Borrando");
						borrarArco(current.getValor(), verticeId);
					}
				}
				arcos.clear();
			}
		return vertices.remove(verticeToDelete);
		}
		return false;
	}

// O(verices.size() + arcos.size()) recorre todos los vertices buscando que existan y luego recorre todos los arcos del vertice origen
	@Override
	public boolean agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		// TODO Auto-generated method stub
		boolean added = false;
		if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) {
			Vertice current = new Vertice(verticeId1);
				if (!existeArco(verticeId1, verticeId2)) {
					Arco a = new Arco(verticeId1, verticeId2, etiqueta);
					current = vertices.get(getIndex(current));
					added = current.setArcos(a);
				}
		}
		return added;
	}

// O(verices.size() + arcos.size()) Recorre todos los vertices y todos los arcos
	@Override
	public boolean borrarArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		if (existeArco(verticeId1, verticeId2)) {
			Vertice current = new Vertice(verticeId1);
			current = vertices.get(getIndex(current));
			Arco a = new Arco(verticeId1, verticeId2, null);
			deleted = current.delete(a);
		}
		return deleted;
	}

// O(vertices) En el peor de los casos recorre todos vertices de la lista
	@Override
	public boolean contieneVertice(int verticeId) {
		// TODO Auto-generated method stub
//		Vertice current = new Vertice(verticeId);
		return vertices.contains(new Vertice(verticeId));
	}

// O(verices.size() + arcos.size()) Itera todos los vertices y todos los arcos del vertice origen
	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		Vertice v1 = new Vertice(verticeId1);
		if (vertices.contains(v1)) {
			v1 = vertices.get(getIndex(v1));
			Iterator<Arco> it = v1.getArcos().iterator();
			while (it.hasNext()) {
				if (it.next().getVerticeDestino()==verticeId2) {
					return true;
				}
			}
		}
		return false;
	}
/*
	@Deprecated
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
*/

// O(verices.size() + arcos.size()) Itera todos los vertices y luego Itera por todos los arcos buscando los vertices correspondientes
	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		Vertice current = new Vertice(verticeId1);
		if (vertices.contains(current) && vertices.contains(new Vertice(verticeId2))) {
			int index = getIndex(current);
			Vertice v = vertices.get(index);
			Iterator<Arco> it = v.getArcos().iterator();
			while (it.hasNext()) {
				Arco a = it.next();
				if (a.getVerticeOrigen()==verticeId1 && a.getVerticeDestino() == verticeId2) {
					return a;
				}

			}
		}
		return null;
	}

//	O(1) Consulta a un metodo de la lista que consulta a una variable
	@Override
	public int cantidadVertices() {
		// TODO Auto-generated method stub
		return vertices.size();
	}

// O(vertices.size()) recorre los vertices y pregunta por el size y lo suma
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

// O(arcos.size()) va a recorrar todos los arcos del vertice devolviendo los vertices destino
	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		Vertice finalCurrent = vertices.get(getIndex(new Vertice(verticeId)));
		Iterator<Integer> it = new Iterator() {
			private int index = 0;
			@Override
			public boolean hasNext() {
				return index < finalCurrent.getArcos().size() && finalCurrent.getArcos().get(index) != null;
			}

			@Override
			public Integer next() {
				Arco a = (Arco) finalCurrent.getArcos().get(index++);
				return a.getVerticeDestino();
			}
		};
		return it;
	}

// O(vertices.size()) Itera por los vertices pidiendo y guardando todos los arcos que tenga
	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		ArrayList<Arco<T>> aux = new ArrayList<>();
		Iterator<Vertice> it = vertices.iterator();
		while (it.hasNext()) {
			aux.addAll(it.next().getArcos());
		}
		return aux.iterator();
	}

// O(1) Devuelve el iterador de arcos del vertice solicitado la complejidad queda fuera del metodo
	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return vertices.get(getIndex(new Vertice(verticeId))).getArcos().iterator();
	}
// Idem metodo anterior
	public boolean isFinal(int verticeId) {
		 return vertices.get(getIndex(new Vertice(verticeId))).getArcos().isEmpty();
	}
}