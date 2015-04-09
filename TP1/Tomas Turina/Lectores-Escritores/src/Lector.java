
public class Lector implements Runnable
{
	Recurso libro;
	
	public Lector(Recurso lib)
	{
		libro = lib;
	}

	@Override
	public void run() 
	{
		for(int i=0;i<10;i++)
		{
			libro.leer(); //Lee el libro si se puede, sino espera
		}
	}
}
