package grafo;

public class GrafoDirigido extends Grafo {

	public GrafoDirigido(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	@Override
	void seteaAdyacencia(int verticeOrigen, int verticeDestino, int peso) {
		matrizAdyacencia[verticeOrigen-1][verticeDestino-1]= peso;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
