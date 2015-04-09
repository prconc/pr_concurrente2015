
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
		while(true)
		{
			buffer.inc();
			System.out.print("\n");
			buffer.mostrarBuffer();
			System.out.print("\n");
		}
	}

}
