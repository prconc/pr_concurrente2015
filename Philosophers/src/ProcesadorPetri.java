import java.util.Arrays;

public class ProcesadorPetri {
	
	private int [][] I;
	private int [] marcado;
	private boolean es_posible = true;
	
	public ProcesadorPetri (int [][] MI, int []marcado){
		
		I = MI;
		this.marcado=marcado;
		
	}

	synchronized public boolean ejecutar (final int [] disparo)
	{
		
	    int sum=0;                         // multiplicar matriz.
	    int multiplicacion[] = new int[marcado.length];	
	    
	    for(int i=0; i<I.length; i++){        
	        for(int k=0; k<I[i].length; k++){
	        sum=sum+I[i][k]*disparo[k];
	        }
	        multiplicacion[i] = sum;

	        sum=0;
		}

		for(int i=0; i<marcado.length; i++){ //Verificar si es posible el disparo.
	       
			if(this.marcado[i]+multiplicacion[i]==-1) { // Si algun elemento del marcado es -1, el disparo no es posible
			    es_posible = false;
			    // System.out.println("El disparo" + Arrays.toString(disparo) + "no es posible");
			}
		}
	
		// Actualizar marcado si el disparo fue posible.
		if (es_posible){
			for(int i=0; i<marcado.length; i++){
					this.marcado[i] = this.marcado[i] + multiplicacion[i];
			}
			// System.out.println("El disparo" + Arrays.toString(disparo) + "si es posible");
			return true;
		}	
		else{
			es_posible = true;
			// Se retorna la bandera al estado original.
			return false;	
		}
		
	}
	
	synchronized public void get_marcado(){
		System.out.println("Marcado: "+ Arrays.toString(this.marcado) );	
	}
	
	
}