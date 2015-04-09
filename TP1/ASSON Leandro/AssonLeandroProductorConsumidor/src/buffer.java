
public class buffer 

{
private int [] Buffer ;
private int tamaño;
private int contador;
	

public buffer()// constructor de la clase buffer.
{
	tamaño = 10;
    Buffer = new int[tamaño];
    contador=0;
}


public synchronized void agregar(int numeroaleatorio)
{
	if(contador<tamaño)
	{
		Buffer[contador]=numeroaleatorio;
	    contador ++;
	    System.out.println("El hilo "+ Thread.currentThread().getName() +" AGREG en la posicion " + (contador-1) + " el numero:" + numeroaleatorio );
		notify();	
	}
	else 
	   {
		    try
	         {
		       System.out.println("El hilo "+ Thread.currentThread().getName() +" ESTA ESPERANDO PARA AGREGAR el numero:" + numeroaleatorio );
		       wait();
	           agregar(numeroaleatorio);   
	         }
		    catch(InterruptedException c )
		    {
		    	c.printStackTrace();
		    }
	   }
	
	
	
}



public synchronized int quitar()
{
	if(contador>0)
	{
		
	    contador --;
	    System.out.println("El hilo "+ Thread.currentThread().getName() +" QUITO en la posicion " + contador + " el numero:" + Buffer[contador ] );
		notify();
	    return Buffer[contador];
	}
	else 
	   {
		    try
	         {
		    	System.out.println("El hilo "+ Thread.currentThread().getName()+" ESTA ESPERANDO PARA QUITAR");
		    	wait();
	           return quitar();   
	         }
		    catch(InterruptedException c )
		    {
		    	c.printStackTrace();
		    	return -1;
		    }
	   }
	
	
	
}



}
