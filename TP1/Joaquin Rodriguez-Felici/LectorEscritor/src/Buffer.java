import java.util.List;
import java.util.ArrayList;

public class Buffer 
{
	private List<String> buffer;
	private int lectores;
	private boolean escritor;
	private int escritoresEsperando;

	public Buffer()
	{
		buffer = new ArrayList<String>();
		escritor = false;
		escritoresEsperando = 0;
		lectores = 0;
	}
	
	public void escribir(String palabra)
	{
		synchronized(this)
		{
			while(escritor || lectores>0)
			{
				try
				{
					escritoresEsperando++;
					System.out.println("(" + lectores + "|" + escritor + ") El escritor " + Thread.currentThread().getName() + " ESTÁ ESPERANDO... \n");
					wait();
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				escritoresEsperando--;
			}
			
				escritor = true;
				System.out.println("(" + lectores + "|" + escritor + ") El escritor " + Thread.currentThread().getName() + " está escribiendo *" + palabra + "*");
				buffer.add(palabra);
				
				try
				{
					Thread.sleep(200);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				
				System.out.println("(" + lectores + "|" + escritor + ") El escritor " + Thread.currentThread().getName() + " terminó de escribir *" + palabra + "* \n");
				escritor = false;
				notifyAll();
		}
	}
		
	
	public void leer(int index)
	{
		synchronized(this)
		{
			while(escritor || buffer.isEmpty() || escritoresEsperando>0)
			{
				try
				{
					System.out.println("(" + lectores + "|" + escritor + ") El lector " + Thread.currentThread().getName() + " ESTÁ ESPERANDO... \n");
					wait();
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			lectores++;	
		}
		
		System.out.println("(" + lectores + "|" + escritor + ") El lector " + Thread.currentThread().getName() + " está leyendo *" + buffer.get(index) + "* \n");
		
		try
		{
			Thread.sleep(200);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		synchronized(this)
		{
			lectores--;
			System.out.println("(" + lectores + "|" + escritor + ") El lector " + Thread.currentThread().getName() + " terminó de escribir *" + buffer.get(index) + "* \n");
			if(lectores==0)
			notifyAll();
		}
	}
	
	public synchronized int size()
	{
		if(!buffer.isEmpty())
		return buffer.size();
		else
		return 1;
	}
}
