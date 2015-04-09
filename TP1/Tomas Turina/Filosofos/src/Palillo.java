
public class Palillo 
{
	int numero;
	boolean disponible;
	
	public Palillo(int n)
	{
		numero = n;
		disponible = true; //Se inicializan los palillos disponibles para usar
	}
	
	synchronized public void tomar() //Si esta disponible se puede utilizar, caso contrario se espera
	{
		while(!disponible)
		{
			try
			{
				wait();
			}
			catch(Exception e)
			{
			}
		}
		disponible = false; //Deja de estar disponible
	}
	
	synchronized public void dejar() //Una vez utilizado vuelve a estar disponible
	{
		disponible = true;
		notifyAll();
	}

	synchronized boolean get_disponible()
	{
		return disponible;
	}
}
