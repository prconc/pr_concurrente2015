
public class Palitos 
{
	boolean libre;
	
	public Palitos()
	{
		libre = true;
	}
	
	synchronized public void tomarPalito()
	{
		while(!libre)
		{
			try 
			{
				wait();
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		libre = false;
	}
	
	synchronized public void dejarPalito()
	{
		libre = true;
		notifyAll();
	}
	
	public boolean estaLibre()
	{
		return libre;
	}
}
