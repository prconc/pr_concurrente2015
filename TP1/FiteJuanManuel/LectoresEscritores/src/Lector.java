
public class Lector extends Thread
{
	int miID;
	Recurso recurso;
	
	public Lector (Recurso _recurso, int _miID)
	{
		miID=_miID;
		recurso=_recurso;
	}
	
	public void run()
	{
		int i=0;
		while(i<10)
		{
			System.out.println("Lector "+miID+" quiere leer");
			recurso.leer();
			System.out.println("Lector "+miID+" ha terminado");
			i++;
		}
	}
}
