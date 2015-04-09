
public class Contador 
{
private int tope;
private int contador;

public Contador(int tope)
{
	contador = 0;
	this.tope =tope;	
}
	
public void incrementarcontador()
{
   while(contador==tope)
    {
	  try
	   {
		  wait();
	   }
	  catch(Exception e){}
	}

   contador++;
}

synchronized public void decrementarcontador()
{
contador--;	
notifyAll();
}

	
}
