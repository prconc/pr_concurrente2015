
public class Consumidor implements Runnable 
{
	Buffer buffer;
	Thread hiloconsumidor;
	public Consumidor(){}
	public Consumidor(String name, Buffer b)
	{
		buffer = b;
		hiloconsumidor = new Thread (this, name);
		System.out.println(hiloconsumidor.getName());
		hiloconsumidor.start();
		
	}
	
	public void run()
	{
		for(int i=0;i<1000;i++)
		{
			buffer.dec();
			
		}
	}
	

}
