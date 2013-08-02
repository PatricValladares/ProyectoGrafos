package grafo;

public final class FuncionesComunes {
	
	public static void muestraMatriz (int [][] matriz){
		for (int i=0; i< matriz.length; i++){
			for (int j=0; j< matriz.length; j++)
				System.out.print(matriz[i][j]+ " ");
			System.out.println();
		}
	}
	
	public static void muestraVector (int []vector){
		for (int i=0; i< vector.length; i++)
			System.out.print(vector[i]+ " ");
		System.out.println();
	}
	
	public static void inicializaMatriz (int [][] matriz){
		for (int i=0; i< matriz.length; i++){
			for (int j=0; j< matriz.length; j++)
				matriz[i][j]=0;
		}
	}
	
	public static void inicializaVector (int []vector){
		for (int i=0; i< vector.length; i++)
			vector[i]=0;
	}
		
		

}
