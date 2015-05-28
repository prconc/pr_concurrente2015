package monitor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import petri.Rdp;
import petri.Matrix;

/*Clase monitor que administra a los filosofos.
 * Los campos que posee son: Una RdP la cual contiene los recursos disponibles actualmente para que los filosofos actuen.
 * Un objeto Lock para administrar la exclusion mutua de entrada.
 * Y un objeto Condition para administrar los lock por falta de recursos.
 */

public class Monitor {
	
	Rdp petri;
	private Lock lock = new ReentrantLock();			//lock para exclusion mutua
	private Condition esdisparable = lock.newCondition();
	
	/*Al constructor se le ingresa una RdP la cual le establece las condiciones de disparo */
	
	public Monitor(Rdp petri){this.petri=petri;}
	
	/*El metodo comer recibe una Matrix que es el vector de disparo que se trada de aplicar, y el nombre del filosofo que lo ejecuta*/
	
	public void comer(Matrix disparo,String nombre_filosofo) throws InterruptedException {
		
		lock.lock();		//El filosofo adquiere el lock de entrada.
		try{
			while(!petri.probar_disparo(disparo)){						//Mientras el filosofo no posea los palillos para disparar.
				
				System.out.println("Filosofo "+nombre_filosofo+" no puede comer. Encolado.");
				esdisparable.await();									//Se encola.
				}

				System.out.println(nombre_filosofo+" come.");
				petri.disparar(disparo);								//Cuando puede, dispara y modifica el marcado de la RdP.
				
		} finally {
			lock.unlock();				//libero lock y salgo
		}
	}
	
	/* El metodo devolver recibe una Matrix con el vector de disparo, y un string con el nombre del filosofo */
	
	public void devolver_palillo(Matrix disparo, String nombre_filosofo) throws InterruptedException{
		lock.lock();					//Adquiere el lock de entrada
		try {
			System.out.println(nombre_filosofo+" devuelve palillo.");
			petri.disparar(disparo);	//Devuelvo los palillos.
			esdisparable.signal();		//Despierto un filosofo esperando.
		} finally {
			lock.unlock();				//Devuelvo lock
		}
}	
	}


