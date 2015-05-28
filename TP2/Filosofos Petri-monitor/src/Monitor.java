import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {
	procesadorpetri Petri= new procesadorpetri();
	private Lock lock = new ReentrantLock();
	private Condition Palillos = lock.newCondition();	



	public void comer(Matrix Disparo,int id) {
		lock.lock();
		while(!Petri.disparar(Disparo))
		{
			try {
				System.out.println("Filosofo "+ id+" espera por palillos.");
				Palillos.await();
			} catch (InterruptedException e) {
				e.printStackTrace();}
		}
		System.out.println("Filosofo "+ id+" comiendo.");
		lock.unlock();
	}
	public void Soltar(Matrix Disparo,int id)
	{
		lock.lock();
		Petri.disparar(Disparo);
		System.out.println("Filosofo "+ id+" devuelve palillos.");
		Palillos.signal();
		lock.unlock();
	}
}