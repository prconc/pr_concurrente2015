import java.util.Random;

public class Productor implements Runnable
{
	private Buffer buffer;
	private Random random;
	
	public Productor(Buffer buffer)
	{
		this.buffer = buffer;
		random = new Random();
		Thread.currentThread().setPriority(10);
	}
	
	public void run()
	{
		for(int i=0; i<100; i++)				//Cada productor intenta agregar 100 elementos al buffer.
		{
			int r = random.nextInt(100);		//Valor random que se agrega al buffer
			int t = 100 + random.nextInt(900);	//Tiempo random que se espera luego de agregar un elemento al buffer. Entre 100 y 1000.
			
			buffer.agregar(r);					//Agrega el elemento random r.
			
			try
			{
				Thread.sleep(t);				//Duerme durante random milisegundos antes de agregar otro.
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
