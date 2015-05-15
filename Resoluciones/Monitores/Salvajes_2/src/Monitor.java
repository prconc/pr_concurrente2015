import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Monitor implements MonitorInterface {


	Olla olla;
	private Lock lock = new ReentrantLock();			//lock para exclusi�n mutua
	private Condition llenar = lock.newCondition();		//Condicion donde espera el cocinero.
	private Condition vacia = lock.newCondition();		//condicion donde esperan los salvajes.
	private boolean waiting=false;


	public Monitor(Olla olla) {
		this.olla=olla;
	}

	/* (non-Javadoc)
	 * @see MonitorInterface#cocinar()
	 */
	@Override
	public void cocinar() throws InterruptedException {
		lock.lock();
		try{

			if (!waiting || olla.getCapacidad()==olla.getMisioneros()) {//Si nadie espera o la olla esta llena espera.
				System.out.print("cocinero duerme\n");
				llenar.await();       //hace esperar a los thread que estan esperando por esta condicion
			}
			olla.setMisioneros(olla.getMisioneros()+1);
			System.out.print("cocinero , hay "+olla.getMisioneros()+"\n");
			if(olla.getCapacidad()==olla.getMisioneros()) {// Si la olla esta llena notifico.
				vacia.signal();       //avisa a los thread pueden reanudar su ejecucion
			}
		}
		finally{
			lock.unlock();
		}
	}

	/* (non-Javadoc)
	 * @see MonitorInterface#comer()
	 */
	@Override
	public void sacarMisionero() throws InterruptedException {
		lock.lock();
		try{

			if (waiting) {//Si hay salvajes esperando me pongo en la cola.
				System.out.print("salvaje encolado\n");
				vacia.await();
			}

			if(olla.getMisioneros() == 0){		//La olla esta vacia:
				llenar.signal();		//Despierto al cocinero.
				waiting=true;			//Aviso que hay gente esperando.
				System.out.print("salvaje despierta cocinero y espera\n");
				vacia.await();			//Me pongo en la cola
				waiting=false;			//Si llego a este punto quiere decir que me despertaron pq la olla esta llena.

			}

			olla.setMisioneros(olla.getMisioneros()-1);				//como 1 misionero
			System.out.print("salvaje come, quedan "+ olla.getMisioneros()+"\n");
			vacia.signal();       		//aviso a otro salvaje que puede comer.
		} finally {
			lock.unlock();				//libero lock y salgo
		}

	}

}
