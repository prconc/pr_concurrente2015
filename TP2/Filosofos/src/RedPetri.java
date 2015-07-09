import java.util.Arrays;

public class RedPetri
{
	private int [][] I = {{-1,1,0,0,0,0,0,0,0,0},
			 			  {1,-1,0,0,0,0,0,0,0,0},
			 			  {0,0,-1,1,0,0,0,0,0,0},
			 			  {0,0,1,-1,0,0,0,0,0,0},
			 			  {0,0,0,0,-1,1,0,0,0,0},
			 			  {0,0,0,0,1,-1,0,0,0,0},
			 			  {0,0,0,0,0,0,-1,1,0,0},
			 			  {0,0,0,0,0,0,1,-1,0,0},
			 			  {0,0,0,0,0,0,0,0,-1,1},
			 			  {0,0,0,0,0,0,0,0,1,-1},
			 			  {-1,1,-1,1,0,0,0,0,0,0},
			 			  {0,0,-1,1,-1,1,0,0,0,0},
			 			  {0,0,0,0,-1,1,-1,1,0,0},
			 			  {0,0,0,0,0,0,-1,1,-1,1},
			 			  {-1,1,0,0,0,0,0,0,-1,1},};
	
	private int [] marcado = {1,0,1,0,1,0,1,0,1,0,1,1,1,1,1};
	
	private boolean es_posible = true;
	  
	synchronized public boolean disparar (final int [] disparo)
	{
	    int sum=0;
	    int multiplicacion[] = new int[15];	
	    
	    for(int i=0; i<15; i++)
	    {        
	        for(int k=0; k<10; k++)
	        {
	        	sum=sum+I[i][k]*disparo[k];
	        }
	        multiplicacion[i] = sum;
	        sum=0;
		}

		for(int i=0; i<15; i++)
		{
			if(this.marcado[i]+multiplicacion[i]==-1) 
			{
			    es_posible = false;
			}
		}
	
		if (es_posible)
		{
			for(int i=0; i<15; i++)
			{
					this.marcado[i] = this.marcado[i] + multiplicacion[i];
			}
			return true;
		}	
		else
		{
			es_posible = true;
			return false;	
		}
	}
	
	synchronized public void imprimir_marcado()
	{
		System.out.println("Marcado: "+ Arrays.toString(this.marcado) );	
	}	
}