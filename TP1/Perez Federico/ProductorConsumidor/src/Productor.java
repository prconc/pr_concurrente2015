
public class Productor implements Runnable 
{
	Buffer buffer;
	Thread hiloproductor;
	public Productor(){}
	public Productor(String name, Buffer b)
	{
		buffer = b;
		hiloproductor = new Thread (this, name);
		System.out.println(hiloproductor.getName());
		hiloproductor.start();
		
	}
	
	public void run()
	{
		for(int i=0;i<1000;i++)
		{
			buffer.inc();

		}
	}

}
