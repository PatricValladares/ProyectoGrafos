package algoritmos;

import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.Queue;

import grafo.FuncionesComunes;
import grafo.GrafoDirigido;
import grafo.GrafoNoDirigido;

public class BFS {
	GrafoDirigido grafo;
	int [] estado;
	int [] distancia;
	int [] padre;
	
	

	public BFS(GrafoDirigido g) {
		grafo = g;
		estado = new int [grafo.cantVertices];
		distancia = new int [grafo.cantVertices];
		padre = new int [grafo.cantVertices];	
		
	}

	public void resuelve (int verticeOrigen){		
		
		Queue<Integer>cola = new LinkedList<Integer>();
		int vertice =0;		
		
		for (int i=0; i< grafo.cantVertices ; i++){
			estado[i]= 0;
			distancia[i]= Integer.MAX_VALUE;
			padre[i]= -1;
		}
		
		estado[verticeOrigen-1]=1;
		distancia[verticeOrigen-1]=0;
		padre[verticeOrigen-1]=0;
		cola.add(verticeOrigen);
		
		
		while (!cola.isEmpty()){
			
			vertice = cola.poll();
			for (int i=0; i< grafo.cantVertices; i++){
				if (grafo.son_adyacentes(vertice, i+1)){
					
					if (estado[i]==0){
						estado[i]=1;
						distancia[i]=distancia[vertice-1]+1;
						padre[i]= vertice;
						cola.add(i);
					}					
				}
			}			
		}		
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GrafoDirigido grafo = new GrafoDirigido("LoteDePrueba/Input/03_GrafoNoArbol.in");
		BFS resuelve = new BFS(grafo);
		resuelve.resuelve(1);
		FuncionesComunes.muestraVector(resuelve.distancia);
		FuncionesComunes.muestraVector(resuelve.estado);
		FuncionesComunes.muestraVector(resuelve.padre);

	}

}
