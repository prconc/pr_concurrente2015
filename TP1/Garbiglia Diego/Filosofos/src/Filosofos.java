public class Filosofos implements Runnable 
{
	private int id;
	Palitos izq, der;
	
	public Filosofos(int id, Palitos izq, Palitos der)
	{
		this.id = id;
		this.izq = izq;
		this.der = der;
	}
	
	synchronized public void comer()
	{
		while(!(izq.estaLibre() && der.estaLibre()))
		{
			pensar();
		}
		
		izq.tomarPalito();
		der.tomarPalito();
		try 
		{
			Thread.sleep(200);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();// TODO: handle exception
		}
		
			
		izq.dejarPalito();
		der.dejarPalito();
		
		notifyAll();
		
	}

	public void pensar()
	{
		System.out.print("El filosofo" + id + "Esta pensando");
		try 
		{
			Thread.sleep(100);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() 
	{
		comer();
	}
}
