
public class Escritor extends Thread 
{
	int miID;
	Recurso recurso;
	
	public Escritor (Recurso _recurso, int _miID)
	{
		miID=_miID;
		recurso=_recurso;
	}
	
	public void run()
	{
		int i=0;
		while(i<10)
		{
			System.out.println("Escritor "+miID+" quiere escribir");
			recurso.escribir();
			System.out.println("Escritor "+miID+" ha terminado");
			i++;
		}
	}
}
