import java.util.Random;

public class Consumidor implements Runnable
{
	private Buffer buffer;
	private Random random;
	
	public Consumidor(Buffer buffer)
	{
		this.buffer = buffer;
		random = new Random();
		Thread.currentThread().setPriority(1);
	}
	
	public void run()
	{
		for(int i=0; i<100; i++)			//Cada consumidor intenta quitar 100 elementos al buffer.
		{
			int t =  100 + random.nextInt(900); 	//Tiempo random que se espera luego de consumir un elemento del buffer.

			buffer.quitar();				//Quita el ultimo elemento que se agregó al buffer.
			
			try
			{
				Thread.sleep(t);			//Duerme durante random milisegundos antes de quitar otro.
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}
	}
}