
public class Escritor implements Runnable
{
	Recurso libro;
	
	public Escritor(Recurso lib)
	{
		libro = lib;
	}

	@Override
	public void run() 
	{
		for(int i=0;i<10;i++)
		{
			libro.escribir(); //Escribe en el libro si se puede, sino espera
		}
	}
}
