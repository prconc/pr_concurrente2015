
public class Buffer {
	
	private char B[] = new char[10];
	private int ult = -1;
	
	public Buffer()
	{
		for(int i=0;i<10;i++)
		{
			B[i]= '-';
		}
	}

	public synchronized void inc()
	{
		if(ult == 9)
		{
			try
			{
            wait();
        	}catch(InterruptedException ex){}
		}
		ult = ult + 1;
		B[ult]='O';
		notify();
		
	}

	public synchronized void dec()
	{
		if(ult == -1)
		{
			try
			{
            wait();
        	}
		catch(InterruptedException ex){}
		}
		B[ult]='-';
		ult = ult-1;
		notify();
		
	}
	
	public synchronized void mostrarBuffer()
	{
	
		for(int i=0;i<10;i++)
		{
			System.out.print(B[i]);
		}
	}
	

}