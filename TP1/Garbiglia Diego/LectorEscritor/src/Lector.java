
public class Lector implements Runnable {

	Buffer b;
	int indice;
	
	public Lector(Buffer b, int indice)
	{
		
		this.indice = indice;
		this.b = b;
		
	}
	
	public void run()
	{
		b.leer(indice);
		
	}
	
	
	
	
}
