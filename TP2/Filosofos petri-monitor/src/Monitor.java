import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {
	private ProcesadorPetri petri;
	private Lock lock;
	private Condition tenedorEnUso;
	
	public Monitor(int [][] incidence, int [][] marking){
		this.petri = new ProcesadorPetri(incidence,marking);
		this.lock = new ReentrantLock();
		this.tenedorEnUso = lock.newCondition();
	}
	
	public void comer(Matrix disparo, int id){
		lock.lock();
		while(!petri.disparar(disparo)){
			try{
				System.out.println("Filosofo "+id+" esperando para comer.");
				tenedorEnUso.await();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		System.out.println("Filosofo "+id+" comiendo.");
		lock.unlock();
	}
	
	public void dejarDeComer(Matrix disparo, int id){
		lock.lock();
		petri.disparar(disparo);
		System.out.println("Filosofo "+id+" suelta tenedores.");
		tenedorEnUso.signal();
		lock.unlock();
	}
}
