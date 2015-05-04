public class Filosofo implements Runnable
{
	private int num_fil;
	private Mesa mesa;	
	private Semaforo semaforo;
	
	public Filosofo(int fil, Mesa m, Semaforo s)
	{
		num_fil = fil;
		mesa = m;
		semaforo = s;
	}
	
	public void pensar()
	{
		try
		{
			System.out.println("El Filosofo: " + Thread.currentThread().getName() + " esta pensando");
			Thread.sleep(200); //Tiempo que tarda en pensar
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public void comer()
	{
		semaforo.Wait();
		
		if(!mesa.get_disponible(num_fil) || !mesa.get_disponible((num_fil+1)%5))
	    System.out.println("El Filosofo: " + Thread.currentThread().getName() + " esta esperando");
		
		while(!mesa.get_disponible(num_fil) || !mesa.get_disponible((num_fil+1)%5))
		{
			semaforo.Signal();
			semaforo.Wait();	
		}
		
		mesa.set_disponible(num_fil, false);
		mesa.set_disponible((num_fil+1)%5, false);
		semaforo.Signal();
		
		try
		{
			System.out.println("El Filosofo: " + Thread.currentThread().getName() + " esta comiendo");
			Thread.sleep(200); //Tiempo que tarda en comer
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		semaforo.Wait();
		mesa.set_disponible(num_fil, true);
		mesa.set_disponible((num_fil+1)%5, true);
		System.out.println("El Filosofo: " + Thread.currentThread().getName() + " termino de comer");
		semaforo.Signal();
	}
	
	public void run()
	{	
		int i = 0;
		while(i<10)
		{
			pensar();
			comer();
			i++;
		}
	}
}