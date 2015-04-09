
public class Contador 
{
	int cont;
	int tope;
	
	Contador (int _tope)
	{
		cont = 0;
		tope = _tope;
	}
	
	public void inc ()
	{
		while (cont==tope)
		{
			try{wait();}
			catch(Exception e) {}
		}
		cont++;
	}
	synchronized public void dec ()
	{
		cont--;
		notifyAll();
	}
	
	synchronized public int valor()
	{
		return cont;
	}
}