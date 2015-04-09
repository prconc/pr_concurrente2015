
public class Semaforo 
{
	protected int valor;
	private boolean es_binario;
	
	public Semaforo(boolean bin, int inicio)
	{
		valor = inicio;
		es_binario = bin;
	}
	
	public synchronized void Wait()
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
	
	public synchronized void Signal()
	{
		if(es_binario)
		{
			valor = 1;
		}
		else
		{
			valor++;
		}
		notify();
	}
	
	public int get_valor()
	{
		return valor;
	}
}
