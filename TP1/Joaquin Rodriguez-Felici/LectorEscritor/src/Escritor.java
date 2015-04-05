
public class Escritor implements Runnable
{
	private Buffer buffer;
	
	public Escritor(Buffer buffer)
	{
		this.buffer = buffer;
	}
	
	public void run()
	{
		for(int i=0; i<10; i++)
		{
			buffer.escribir("Palabra-" + Thread.currentThread().getName() + (i+1));
		}
	}
}