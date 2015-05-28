import java.util.concurrent.locks.*;

public class Monitor{

	private Lock lock = new ReentrantLock();  					//lock para la exclusion mutua 
	Procesador_Petri procesador_petri = new Procesador_Petri();
	private Condition habilitacion = lock.newCondition();		//Condicion de espera

	private boolean disparo= false;

	public void tomarPalillos(Filosofos filosofo) {


		lock.lock(); 												     //para que me entren de a uno (exclusion mutua)	
		disparo = this.procesador_petri.disparar(filosofo.disparocomer); //pruebo si el filosofo puede comer

		while(disparo == false){

			try
			{
				System.out.println("El filosofo " + filosofo.getIndice() + " tiene hambre...");
				habilitacion.await();
			}
			catch(InterruptedException e){}
			disparo = this.procesador_petri.disparar(filosofo.disparocomer);
		}

		lock.unlock();
	}
	
	public void soltarPalillos(Filosofos filosofo) {
		lock.lock();
		this.procesador_petri.disparar(filosofo.disparoterminar);

		habilitacion.signal();						
		System.out.println("El filosofo " + filosofo.getIndice() + " termin� de comer...");
		lock.unlock(); //Libero la exclusion mutua

	}
}


