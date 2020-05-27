package tp4;

public class Ejercicio04 {

}

/*
* functionDijkstra(Grafo G, Vértice origen):
*   foreachVértice v en G:               // Inicialización
*       dist[v] := infinito              // La distancia inicial desde el origen al vértice v se establece en infinito
*           padre[v] := indefinido       // El nodo anterior en el camino óptimo desde el origen
*       dist[origen] := 0                // Distancia desde el origen hasta el origen
*       S := vacío                       // S será el conjunto de vértices ya considerados
*       while(G.Vértices–S) no es vacío: // loopprincipal
*           u := vértice en (G.Vértices–S) con menor valor en dist[ ]
*           S := S U {u}
*           foreachv en (G.Vértices–S) que sea adyacente a u://Relajar(u)  r(u)
*               if(dist[u] + dist_entre(u, v)) <dist[v])
*                   dist[v] := dist[u] + dist_entre(u, v)
*                   padre[v] := u
*       returnpadre[ ]
* */
