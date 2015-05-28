import java.util.Arrays;


public class Procesador_Petri {
	
	private int[] marcado;
	private int[][] Matriz;
	private int[] disparo;
	private boolean disparo_posible;
	
	public Procesador_Petri(int[][] mat, int[] marc ){
		
		marcado=marc;
		Matriz=mat;
		disparo_posible=false;
		}
	
	synchronized  public boolean ejecutar( int[] transicion)
		{
		
		int mult[] = { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 };
	    
	    	disparo=transicion;
		
	    	for(int i=0; i<10; i++)
	    	{
	    		for(int j=0; j<10; j++)
	    		{
				mult[i]=mult[i]+Matriz[i][j]*disparo[j]; 
	    		}
	    	}
	    	
	    	for(int i=0; i<10; i++)
	    	{
	    		if(marcado[i]+mult[i]==-1)
	    		{
	    			disparo_posible=true;
	    			break;
	    		}

	    			
	    	}
	    	
	    	if(disparo_posible)
	    	{
	    		//System.out.println("Disparo NO posible"); 
	    		disparo_posible=false;
	    		return true;
	    	}
	    	else
	    		for(int i=0; i<10; i++)
	    		{
	    		marcado[i]=marcado[i]+mult[i];
	    		}
	    	//System.out.println("disparo SI posible"); 
	    		return disparo_posible;
		
	}
	
	synchronized public void imprimir_marcado(){
		System.out.println("Marcado: "+ Arrays.toString(this.marcado) );	
	}

}
