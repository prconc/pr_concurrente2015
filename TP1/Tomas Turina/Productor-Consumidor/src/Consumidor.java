
public class Consumidor implements Runnable //Consume productos del buffer
{
	Buffer buffer;
	
	public Consumidor(Buffer buf)
	{
		buffer = buf;
	}

	@Override
	public void run() 
	{
		for(int i=0;i<100;i++)
		{
				buffer.quitar(); //Consume si no esta vacio
			
			try
			{
				Thread.sleep(1000); //Tiempo que tarda en consumir un producto
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
