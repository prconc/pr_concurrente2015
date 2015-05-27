package logica;




public class Procesador_Petri {

	// Matriz de incidencia.
	private int [][] I = {
			{-1,0,0,0,-1,1,0,0,0,1,0,0,0,0,0},
			{0,0,0,1,0,0,0,0,-1,0,0,0,0,0,0},
			{0,0,0,0,1,0,0,0,0,-1,0,0,0,0,0},
			{0,0,0,0,-1,0,0,0,0,0,0,0,0,0,1},
			{-1,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
			{0,-1,0,0,0,0,0,0,0,0,0,1,0,0,0},
			{0,0,-1,0,0,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,-1,0,0,0,0,0,0,0,0,0,1,0},
			{0,0,0,0,0,0,1,0,0,0,0,-1,0,0,0},
			{0,0,0,0,0,0,0,1,0,0,0,0,-1,0,0},
			{0,0,0,0,0,0,0,0,1,0,0,0,0,-1,0},
			{-1,-1,0,0,0,1,1,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,1,0,0,0,0,-1},
			{0,0,0,0,0,1,0,0,0,0,-1,0,0,0,0},
			{0,0,0,-1,-1,0,0,0,1,1,0,0,0,0,0},
			{0,0,-1,-1,0,0,0,1,1,0,0,0,0,0,0},
			{1,0,0,0,0,-1,0,0,0,0,0,0,0,0,0},
			{0,1,0,0,0,0,-1,0,0,0,0,0,0,0,0},
			{0,-1,-1,0,0,0,1,1,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,-1,0,0,0,0,0,0,0},
	};

	private int [] marcado = {1,0,0,1,1,1,1,1,0,0,0,1,0,0,1,1,0,0,1,0};//marcado inicial

	private boolean es_posible = true;

	synchronized public boolean disparar (final int [] disparo)
	{


		int sum=0;// multiplicar matriz.
		int multiplicacion[] = new int[20];	

		for(int i=0; i<20; i++){        
			for(int k=0; k<15; k++){
				sum=sum+I[i][k]*disparo[k];
			}
			multiplicacion[i] = sum;

			sum=0;
		}

		for(int i=0; i<20; i++){ //Verificar si es posible el disparo.

			if(this.marcado[i]+multiplicacion[i]==-1) { // Si algun elemento del marcado es -1, el disparo no es posible
				es_posible = false;

			}
		}

		// Actualizar marcado si el disparo fue posible.
		if (es_posible){
			for(int i=0; i<20; i++){
				this.marcado[i] = this.marcado[i] + multiplicacion[i];
			}

			return true;
		}	
		else{
			es_posible = true;
			// Se retorna la bandera al estado original.
			return false;	
		}


	}








}
