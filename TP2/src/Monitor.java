import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor
{
	private Lock mutex = new ReentrantLock();					//Para exclusión mutua
	private Condition habilitacion = mutex.newCondition();		//Condicion de espera
	
	public void comer(Filosofo filosofo) 
	{		
			mutex.lock(); //Adquiero la exclusion mutua
			
			filosofo.red.imprimir_marcado();
			filosofo.disparo =  filosofo.red.disparar(filosofo.getdisparo(filosofo.id));
			
			while(filosofo.disparo == false)
			{
				try
				{
					System.out.println("El filosofo " + ((filosofo.id)/2) + " está esperando para comer...");
					habilitacion.await();
				}
				catch(InterruptedException e){}
				filosofo.disparo =  filosofo.red.disparar(filosofo.getdisparo(filosofo.id));
			}
			
				filosofo.red.imprimir_marcado();
				
				mutex.unlock();
				
				try
				{
					System.out.println("El filosofo " + ((filosofo.id)/2) + " está comiendo...");
					Thread.sleep(2000);
				}
				catch(Exception e){}
				
				mutex.lock();
				filosofo.disparo = filosofo.red.disparar(filosofo.getdisparo((filosofo.id)+1));
				filosofo.red.imprimir_marcado();
				
				habilitacion.signal();			
				//System.out.println("Se ha disparado " + filosofo.id + " y " + ((filosofo.id)+1));			
				System.out.println("El filosofo " + ((filosofo.id)/2) + " terminó de comer...");
			    mutex.unlock(); //Libero la exclusion mutua


	}
}