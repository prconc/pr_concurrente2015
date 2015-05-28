

public class Contador 
{
	int cuenta;
	int tope;
	
	Contador(int tope)
	{
		this.tope = tope;
		cuenta = 0;
	}
	
	public void incrementar()
	{
		while(cuenta == tope)
		{
			try
			{
				wait();
			}
			catch(Exception e){}
		}
		cuenta++;
	}
	
	synchronized public void decrementar()
	{
		cuenta--;
		notifyAll();
	}
	
	synchronized public int retornoCuenta()
	{
		return cuenta;
	}
}
