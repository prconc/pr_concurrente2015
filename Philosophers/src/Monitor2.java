import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor2 implements MonitorInterface {
	
	ProcesadorPetri ppetri;
	private Lock lock = new ReentrantLock();			//lock para exclusion mutua
	private Condition haypalillos = lock.newCondition();		//Condicion donde se esperan los palillos.
	private boolean palillos;

	public Monitor2(ProcesadorPetri ppetri) {
		// TODO Auto-generated constructor stub
		this.ppetri = ppetri;
	}

	@Override
	public void comer(int [] disparo) throws InterruptedException {
		// TODO Auto-generated method stub
		
		lock.lock();
		try{ 
			
			palillos = ppetri.ejecutar(disparo);

			if (!palillos) {//si no hay palillos
				haypalillos.await();       //hace esperar a los thread que estan esperando por esta condicion
			}
			
		}
		finally{
			lock.unlock();
		}

	}

	@Override
	public void terminar(int [] disparo) throws InterruptedException {
		// TODO Auto-generated method stub
		lock.lock();
		try{
			
			palillos = ppetri.ejecutar(disparo);

			if (palillos) {//si puede devolver
				haypalillos.signal(); //despierta a los filosofos que esperan dos palillos
			}
		}
		finally{
			lock.unlock();
		}
		
		

	}

}
