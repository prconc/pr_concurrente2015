
public class Productor implements Runnable //Produce y coloca en el buffer
{
	Buffer buffer;
	int producto;
	
	public Productor(Buffer buf, int prod)
	{
		buffer = buf;
		producto = prod;
	}

	@Override
	public void run() 
	{
		for(int i=0;i<100;i++)
		{
			buffer.agregar(producto); //Coloca si no esta lleno

			try
			{
				Thread.sleep(1000); //Tiempo que tarda en producir un producto
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
