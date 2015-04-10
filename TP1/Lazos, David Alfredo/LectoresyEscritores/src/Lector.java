
public class Lector implements Runnable {
	int Lect;
	Recurso recurso;
	
	public Lector (Recurso recurso, int Lect)
	{
		this.Lect=Lect;
		this.recurso=recurso;
	}
	
	public void run()
	{
		int i = 0;
		while (i<10)
		{
			System.out.println("Lector " + Lect + " quiere leer");
			recurso.leer();
			System.out.println("Lector " + Lect + " ha terminado");
			i++;
		}
	}
}
