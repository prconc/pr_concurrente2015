import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Olla {


	private int capacidad;	//capacidad de la olla
	int misioneros;			//numero de misioneros dentro de la olla

	private Lock lock = new ReentrantLock();			//lock para exclusión mutua
	private Condition llenar = lock.newCondition();		//Condicion donde espera el cocinero.
	private Condition vacia = lock.newCondition();		//condicion donde esperan los salvajes.
	private boolean waiting=false;


	public Olla(int i, int capacidad) {
		this.misioneros = i;
		this.capacidad = capacidad;
	}

	public void cocinar() throws InterruptedException {
		lock.lock();
		try{

			if (!waiting || capacidad==misioneros) {//Si nadie espera o la olla esta llena espera.
				System.out.print("cocinero duerme\n");
				llenar.await();       //hace esperar a los thread que estan esperando por esta condicion
			}
			misioneros++;
			System.out.print("cocinero , hay "+misioneros+"\n");
			if(capacidad==misioneros) {// Si la olla esta llena notifico.
				vacia.signal();       //avisa a los thread pueden reanudar su ejecucion
			}
		}
		finally{
			lock.unlock();
		}
	}

	public void comer() throws InterruptedException {
		lock.lock();
		try{

			if (waiting) {//Si hay salvajes esperando me pongo en la cola.
				System.out.print("salvaje encolado\n");
				vacia.await();
			}

			if(misioneros == 0){		//La olla esta vacia:
				llenar.signal();		//Despierto al cocinero.
				waiting=true;			//Aviso que hay gente esperando.
				System.out.print("salvaje despierta cocinero y espera\n");
				vacia.await();			//Me pongo en la cola
				waiting=false;			//Si llego a este punto quiere decir que me despertaron pq la olla esta llena.

			}

			misioneros--;				//como 1 misionero
			System.out.print("salvaje come, quedan "+ misioneros+"\n");
			vacia.signal();       		//aviso a otro salvaje que puede comer.
		} finally {
			lock.unlock();				//libero lock y salgo
		}

	}

}
