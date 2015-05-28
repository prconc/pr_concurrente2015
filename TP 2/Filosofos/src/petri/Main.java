package petri;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Filosofo f[] = new Filosofo[5];
		int numEj= 10;		
		
		int [][] I = {   			// Matriz de incidencia.
	 			 { -1,  0,  0,  0, -1,  1,  0,  0,  0,  1 },
	 			 { -1, -1,  0,  0,  0,  1,  1,  0,  0,  0 },
	 			 {  0, -1, -1,  0,  0,  0,  1,  1,  0,  0 },
	 			 {  0,  0, -1, -1,  0,  0,  0,  1,  1,  0 },
	 			 {  0,  0,  0, -1, -1,  0,  0,  0,  1,  1 },
	 			 { -1,  0,  0,  0,  0,  1,  0,  0,  0,  0 },
	 			 {  0, -1,  0,  0,  0,  0,  1,  0,  0,  0 },
	 			 {  0,  0, -1,  0,  0,  0,  0,  1,  0,  0 },
	 			 {  0,  0,  0, -1,  0,  0,  0,  0,  1,  0 },
	 			 {  0,  0,  0,  0, -1,  0,  0,  0,  0,  1 },
	 		 	 {  1,  0,  0,  0,  0, -1,  0,  0,  0,  0 },
	 			 {  0,  1,  0,  0,  0,  0, -1,  0,  0,  0 },
	 			 {  0,  0,  1,  0,  0,  0,  0, -1,  0,  0 },
	 			 {  0,  0,  0,  1,  0,  0,  0,  0, -1,  0 },
	 			 {  0,  0,  0,  0,  1,  0,  0,  0,  0, -1 },
	 			 
	 		   	 };

		int [][] marcado = {{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 },
						};
		
		Monitor m = new Monitor(I, marcado);
		
		for (int i=0; i<5;i++){
			f[i]=new Filosofo (i, numEj, m);
			Thread p = new Thread(f[i]);
			p.start();
		}
	}

}
