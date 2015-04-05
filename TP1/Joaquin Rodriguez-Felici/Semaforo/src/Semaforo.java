
public class Semaforo 
{
	protected int valor;
	private boolean isBinary;
	
	public Semaforo(boolean b, int inicial)
	{
		valor = inicial;
		isBinary = b;
	}
	
	public synchronized void WAIT()
	{
		while(valor==0)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		valor--;
	}
	
	public synchronized void SIGNAL()
	{
		if(isBinary)
		valor = 1;
		else
		valor++;
		
		notify();
	}
	
	public int getValor()
	{
		return valor;
	}
}
