import java.util.Random;

public class Lector implements Runnable

	/*
	 * Lee una posición random del buffer, sin remover el dato.
	 */
{
	private Buffer buffer;
	private Random random;
	
	public Lector(Buffer buffer)
	{
		this.buffer = buffer;
		random = new Random();
	}
	
	public void run()
	{
		for(int i=0; i<10; i++)
		{
			if(buffer.size()>0)
			buffer.leer(random.nextInt(buffer.size()));
		}
	}
}