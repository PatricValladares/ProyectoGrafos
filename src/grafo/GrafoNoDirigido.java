package grafo;

public class GrafoNoDirigido extends Grafo {

	public GrafoNoDirigido(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	@Override
	void seteaAdyacencia(int verticeOrigen, int verticeDestino, int peso) {
		matrizAdyacencia[verticeOrigen-1][verticeDestino-1]= peso;
		matrizAdyacencia[verticeDestino-1][verticeOrigen-1]= peso;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GrafoNoDirigido grafo = new GrafoNoDirigido("LoteDePrueba/Input/00_GrafoNoPonderadoNoDirigido.in"); 
		// TODO Auto-generated method stub

	}

}
