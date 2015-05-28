
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] Incidencia = { { 1 , 0 , 0 , 0 , 0 ,-1 , 0 , 0 , 0 , 0 },
								{ 0 , 1 , 0 , 0 , 0 , 0 ,-1 , 0 , 0 , 0 },
								{ 0 , 0 , 1 , 0 , 0 , 0 , 0 ,-1 , 0 , 0 },
								{ 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 ,-1 , 0 },
								{ 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 ,-1 },
								{-1 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 },
								{ 0 ,-1 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 },
								{ 0 , 0 ,-1 , 0 , 0 , 0 , 0 , 1 , 0 , 0 },
								{ 0 , 0 , 0 ,-1 , 0 , 0 , 0 , 0 , 1 , 0 },
								{ 0 , 0 , 0 , 0 ,-1 , 0 , 0 , 0 , 0 , 1 },
								{-1 ,-1 , 0 , 0 , 0 , 1 , 1 , 0 , 0 , 0 },
								{ 0 ,-1 ,-1 , 0 , 0 , 0 , 1 , 1 , 0 , 0 },
								{ 0 , 0 ,-1 ,-1 , 0 , 0 , 0 , 1 , 1 , 0 },
								{ 0 , 0 , 0 ,-1 ,-1 , 0 , 0 , 0 , 1 , 1 },
								{-1 , 0 , 0 , 0 ,-1 , 1 , 0 , 0 , 0 , 1 },
								};
		int [][] m = {{ 0,0,0,0,0,1,1,1,1,1,1,1,1,1,1}};
		
		Matrix I = new Matrix(Incidencia);	
		Matrix marcado = new Matrix(m);
		
		Monitor  monitor = new Monitor(I, marcado);
		
		for(int i = 0 ; i<5; i++){
			Filosofo f = new Filosofo(monitor,i);
			Thread t = new Thread(f);
			t.start();
		}

	}

}
