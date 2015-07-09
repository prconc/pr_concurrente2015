import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor
{
	private Lock mutex = new ReentrantLock();
	private Condition habilitacion = mutex.newCondition();	
	RedPetri red= new RedPetri();

	
	public void agarraPalillos(Filosofo filosofo) 
	{		
			mutex.lock();
			
			red.imprimir_marcado();
			
			while(red.disparar(filosofo.get_disparos().get(filosofo.get_id())) == false)
			{
				try
				{
					System.out.println("El filosofo " + ((filosofo.get_id())/2) + " está esperando...");
					habilitacion.await();
				}
				catch(InterruptedException e){}
			}
			
			red.imprimir_marcado();
				
			mutex.unlock();
	}
	
	public void sueltaPalillos(Filosofo filosofo)
	{
			mutex.lock();
			
			red.disparar(filosofo.get_disparos().get((filosofo.get_id())+1));
			red.imprimir_marcado();
				
			habilitacion.signalAll();			
		
			System.out.println("El filosofo " + ((filosofo.get_id())/2) + " terminó de comer...");
			
			mutex.unlock();
	}
}