package grafo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public abstract class Grafo {

	int[][] matrizAdyacencia;
	public int cantVertices;
	public int cantAristas;
	String nombreArchivo;

	public Grafo(String path) {

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File(path);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			String[] lineaSpliteada;

			// primer linea cant vertices, cant aristas

			linea = br.readLine();
			lineaSpliteada = linea.split(" ");
			cantVertices = Integer.parseInt(lineaSpliteada[0]);
			cantAristas = Integer.parseInt(lineaSpliteada[1]);

			matrizAdyacencia = new int[cantVertices][cantVertices];

			int verticeOrigen;
			int verticeDestino;
			int peso;
			// linea aristas origen, destino, peso
			for (int i = 0; i < cantAristas; i++) {
				linea = br.readLine();
				lineaSpliteada = linea.split(" ");
				verticeOrigen = Integer.parseInt(lineaSpliteada[0]);
				verticeDestino = Integer.parseInt(lineaSpliteada[1]);
				if (lineaSpliteada.length==2)
					peso=1;
				else
					peso = Integer.parseInt(lineaSpliteada[2]);

				seteaAdyacencia(verticeOrigen, verticeDestino, peso);
			}

			//FuncionesComunes.muestraMatriz(matrizAdyacencia);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	abstract void seteaAdyacencia(int verticeOrigen, int verticeDestino,
			int peso);

	public boolean son_adyacentes(int verticeOrigen, int verticeDestino) {
		return verticeOrigen!= verticeDestino &&  matrizAdyacencia[verticeOrigen - 1][verticeDestino - 1] != 0;
	}
	
	public int get_peso (int verticeOrigen, int verticeDestino){
		return matrizAdyacencia[verticeOrigen - 1][verticeDestino - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
