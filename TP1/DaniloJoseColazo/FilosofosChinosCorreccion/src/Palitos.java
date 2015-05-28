

public class Palitos 
{
	boolean libre;
	
	Palitos()
	{
		libre = true;
	}
	
	synchronized public void tomarPalito(int filosofoNumero)
	{
		while(!libre)
		{
			try
			{
				wait();
			}
			catch(Exception e){}
		}
		
	libre = false;
	}

	synchronized public void soltarPalito()
	{
		libre = true;
		notifyAll();
	}
}
