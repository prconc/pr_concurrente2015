package Filosofos;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {
	ProcesadorPetri Ppetri = new ProcesadorPetri();
	private Lock lock = new ReentrantLock();
	private Condition Palillos = lock.newCondition();
	
	public void comer(Matrix disp, int id){
		
		lock.lock();
		while(!Ppetri.ejecutar(disp)){
			
			try {
				System.out.println("Filosofo" + id + "piensa");
				Palillos.await();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		System.out.println("Filosofo" + id +" comiendo." );
		lock.unlock();
		
		
	}
	
	public void devolPalillos(Matrix disp, int id){
		
		lock.lock();
		Ppetri.ejecutar(disp);
		Palillos.signal();
		System.out.println("Filosofo " + id + " devuelve palillos");
		lock.unlock();
		
				
	}
	
}
