public class Filosofo implements Runnable
{
	private int id;
	private Mesa mesa;					// Todos los filosofos quieren comer en la misma mesa
	private Semaforo semaforo;			// Todos los filosofos hacen uso del mismo semaforo para acceder al arreglo de palillos
	
	public Filosofo(int id, Semaforo s, Mesa m)
	{
		this.id = id;
		semaforo = s;
		mesa = m;
	}
	
	public void pensar()
	{
		try
		{
			System.out.println("(" + mesa.getCantidadPalillos() + ") El filosofo " + id + " está pensando...");
			Thread.sleep(3000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public void comer()
	{
		
		// Las siguientes sentencias están en exclusion mutua para que solo el que se siente primero agarre los palillos correspondientes
		semaforo.WAIT();
		
		if(!mesa.comprobar(id) || !mesa.comprobar((id+1)%5))
		System.out.println("(" + mesa.getCantidadPalillos() + ") El filosofo " + id + " esta esperando...");
		
		while(!mesa.comprobar(id) || !mesa.comprobar((id+1)%5))
		{
			semaforo.SIGNAL();
			semaforo.WAIT();	
		}
		
		mesa.set(id, false);
		mesa.set((id+1)%5, false);
		semaforo.SIGNAL();
		
		// Las siguientes sentencias están fuera de la exlusión mutua para permitir la concurrencia al comer
		try
		{
			System.out.println("(" + mesa.getCantidadPalillos() + ") El filosofo " + id + " esta COMIENDO...");
			Thread.sleep(5000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		// Las siguientes sentencias estan en exlusion mutua para modificar el arreglo de Mesa sin conflictos
		
		semaforo.WAIT();
		mesa.set(id, true);
		mesa.set((id+1)%5, true);
		System.out.println("(" + mesa.getCantidadPalillos() + ") El filosofo " + id + " terminó de comer...");
		semaforo.SIGNAL();
	}
	
	public void run()
	{	int i = 0;
		while(i<5)
		{
			pensar();
			comer();
			i++;
		}
	}
}
