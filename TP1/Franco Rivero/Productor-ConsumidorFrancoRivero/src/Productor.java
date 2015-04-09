
public class Productor extends Thread
{
	private Buffer b;
	private int i;
	
	public Productor(Buffer buf,int n)
	{
		b = buf;
		i=n;
		System.out.println("entra el productor" + n);
	}

	@Override
	public void run() 
	{ 
			b.add(i);
			
			System.out.println("agregando el elemento "+ i);
	}
}