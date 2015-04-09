
public class Recurso //Representa el libro, se otorga prioridad a la lectura
{
	int num_lectores;
	boolean escritor;
	
	public Recurso()
	{
		num_lectores = 0;
		escritor = false;
	}
	
	public void leer()
	{
		synchronized(this)
		{
			if(escritor) //Si hay un escritor escribiendo, no se puede leer
			{
				try
				{
					System.out.println("El lector: " + Thread.currentThread().getName() + " esta en espera...");
					wait();
				}
				catch(Exception e)
				{
				}
			}
			System.out.println("El lector: " + Thread.currentThread().getName() + " esta leyendo el libro");
			num_lectores++;
		}
		
		try
		{
			Thread.sleep(100); //Timpo que tarda en leer
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		synchronized(this)
		{
			num_lectores--;
			if(num_lectores == 0) //Si no hay lectores leyendo, se habilita el primer escritor en espera
			{
				notify();
			}
		}
	}
	
	public void escribir()
	{
		synchronized(this)
		{
			if(escritor || num_lectores > 0) //Si hay un escritor escribiendo o algun lector leyendo, no se puede escribir
			{
				try
				{
					System.out.println("El escritor: " + Thread.currentThread().getName() + " esta en espera...");
					wait();
				}
				catch(Exception e)
				{
				}
			}
			System.out.println("El escritor: " + Thread.currentThread().getName() + " esta escribiendo en el libro");
			escritor = true;
		}
			try
			{
				Thread.sleep(200); //Tiempo que tarda en escribir
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			
			synchronized(this)
			{
				escritor = false;
				notify(); //Se habilitan las esperas
			}
	}
}
