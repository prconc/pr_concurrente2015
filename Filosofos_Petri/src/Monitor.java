import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor
{
	private Lock mutex = new ReentrantLock();
	private Condition habilitacion = mutex.newCondition();	
	
	public void comer(Filosofo filosofo) 
	{		
			mutex.lock();
			
			filosofo.get_red().imprimir_marcado();
			
			while(filosofo.get_red().disparar(filosofo.get_disparos().get(filosofo.get_id())) == false)
			{
				try
				{
					System.out.println("El filosofo " + ((filosofo.get_id())/2) + " está esperando...");
					habilitacion.await();
				}
				catch(InterruptedException e){}
			}
			
			filosofo.get_red().imprimir_marcado();
				
			mutex.unlock();
				
			try
			{
				System.out.println("El filosofo " + ((filosofo.get_id())/2) + " está comiendo...");
				Thread.sleep(2000);
			}
			catch(Exception e){}
				
			mutex.lock();
			
			filosofo.get_red().disparar(filosofo.get_disparos().get((filosofo.get_id())+1));
			filosofo.get_red().imprimir_marcado();
				
			habilitacion.signalAll();			
		
			System.out.println("El filosofo " + ((filosofo.get_id())/2) + " terminó de comer...");
			
			mutex.unlock();
	}
}