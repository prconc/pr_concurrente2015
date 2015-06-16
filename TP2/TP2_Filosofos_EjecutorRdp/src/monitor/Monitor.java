package monitor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import rdp.Rdp;
import rdp.Matrix;

/*Clase monitor que administra a los filosofos.
 * Una RdP la cual contiene los recursos disponibles actualmente para que los filosofos actuen.
 * Lock para el mutex de la entrada al monitor.
 * Y un objeto Condition para administrar los lock por falta de recursos.
 */

public class Monitor {
	
	Rdp rdp;
	private Lock lock = new ReentrantLock();
	private Condition esdisparable = lock.newCondition();
	
	/*Al constructor se le pasa una RdP*/
	public Monitor(Rdp rdp){this.rdp=rdp;}
	
	/*El metodo comer recibe el vector de disparo [Matrix] que se quiere disparar
	 *  y el nombre del filosofo que quiere ejecutar ese disparo*/
	public void comer(Matrix disparo,String nombre_filosofo) throws InterruptedException {
		
		lock.lock();		//El filosofo adquiere el lock de entrada.
		try{
			while(!rdp.probar_disparo(disparo)){						//Si el filosofo no tiene los palillos, se encola
				
				System.out.println(nombre_filosofo+" no tiene palillos para comer!! va a ESPERAR en la cola.");
				esdisparable.await();
				}

				System.out.println(nombre_filosofo+" agarró los palillos y empezó a comer.");	//Si puede (tiene palillos)
				rdp.disparar(disparo);					//Dispara modificando el marcado de la rdp.
				
		} finally {
			lock.unlock();				//Libero lock y salgo
		}
	}
	
	/* El metodo devolver_palillo recibe una Matrix con el vector de disparo
	 *  y un string con el nombre del filosofo que lo dispara */
	public void devolver_palillo(Matrix disparo, String nombre_filosofo) throws InterruptedException{
		lock.lock();					//lockea la entrada
		try {
			System.out.println(nombre_filosofo+" devuelve palillo.");
			rdp.disparar(disparo);		//Devuelve los palillos.
			esdisparable.signal();		//Despierta un filosofo esperando en la cola.
		} finally {
			lock.unlock();				//Libera lock y sale
		}
}	
	}


