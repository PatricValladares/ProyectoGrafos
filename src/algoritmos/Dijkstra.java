package algoritmos;

import grafo.FuncionesComunes;
import grafo.GrafoNoDirigido;

public class Dijkstra {
	int [] distancia;
	int [] vistos;
	int [] previo;
	GrafoNoDirigido grafo;
	
	

	public Dijkstra(GrafoNoDirigido grafo) {
		distancia = new int [grafo.cantVertices];
		vistos = new int [grafo.cantVertices]; 
		previo = new int [grafo.cantVertices];
		this.grafo = grafo;
	}
	/**
	 * @param args
	 */
	
	public int [] Resuelve (int verticeOrigen){
		int vertice =0;
		int peso = 0;
		inicializaDistancia(verticeOrigen);
		distancia[verticeOrigen-1] = 0;
		vistos [verticeOrigen-1]=1;
		//previo[verticeOrigen-1] = verticeOrigen;
		while (!todos_vistos()){
			vertice = minimoNoVisto();
			vistos[vertice] =1;
			for (int i=0; i< grafo.cantVertices; i++){
				if (grafo.son_adyacentes(vertice+1, i+1)){
					peso = distancia[vertice]+ grafo.get_peso(vertice+1, i+1);
					if (distancia[i]> peso ){
						distancia[i] = peso;
						previo[i] = vertice+1;
					}
				}
			}			
		}
		return distancia;
		
	}
	
	private void muestraCamino(int verticeDestino){
		if (verticeDestino != 0){
			muestraCamino (previo[verticeDestino-1]);
		System.out.print(verticeDestino+" ");}

			
			
	}
	
	private boolean todos_vistos (){
		boolean todosVistos = true;
		int i = 0;
		while (i< grafo.cantVertices && todosVistos){
			todosVistos= vistos[i] ==1;
			i++;
		}
		return todosVistos;
	}
	
	private int minimoNoVisto (){
		int minimo = Integer.MAX_VALUE;
		int verticeMinimo = 0;
		for (int i=0; i< grafo.cantVertices; i++){
			if (vistos[i]== 0 && distancia[i] <= minimo){
				minimo = distancia[i];
				verticeMinimo = i;				
			}
		}
		return verticeMinimo;				
	}
	
	private void inicializaDistancia (int verticeOrigen){
		for (int i=0 ; i < grafo.cantVertices; i++)
			if (grafo.son_adyacentes(verticeOrigen, i+1)){
				distancia[i] = grafo.get_peso(verticeOrigen, i+1);
				previo [i]= verticeOrigen;
			}
			else
				distancia[i] = Integer.MAX_VALUE;		
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GrafoNoDirigido grafo = new GrafoNoDirigido("LoteDePrueba/Input/01_GrafoPonderadoNoDirigido.in");
		Dijkstra resuelve = new Dijkstra(grafo);
		int []distancia = resuelve.Resuelve(6);
		FuncionesComunes.muestraVector(distancia);
		FuncionesComunes.muestraVector(resuelve.previo);
		resuelve.muestraCamino(5);
	}

}
