
public class Escritor implements Runnable {
	int Lect;
	Recurso recurso;
	
	public Escritor (Recurso recurso, int Lect)
	{
		this.Lect=Lect;
		this.recurso=recurso;
	}
	
	public void run()
	{
		int i = 0;
		while (i < 10)
		{
			System.out.println ("Escritor " + Lect + " quiere escribir" );
			recurso.escribir();
			System.out.println ("Escritor " + Lect + " ha terminado de escribir");
			i++;
		}
	}
}
