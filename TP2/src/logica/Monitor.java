package logica;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Monitor {


	Procesador_Petri procesador = new  Procesador_Petri ();

	private Lock lock = new ReentrantLock();			// lock para exclusión mutua

	private Condition sinpalillo = lock.newCondition(); // Condicion donde espera el Filosofo.


	public void obtenerPalillo (int idfilosofo){

		lock.lock();

		int [] disparo = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

		//calculo del disparo COMER del  idfilosofo Ejemplo : si es el filosofo 3 se genera vector de disparo  (0,0,0,1,0,0,0,0,0,0,0,0,0,0,0)     


		for(int i=0; i<15; i++){        

			if (i==idfilosofo)
				disparo[i]=1;
			else 
				disparo[i]=0;
		}




		while (procesador.disparar(disparo) == false){

			try {

				System.out.print("Filosofo " + idfilosofo + " Sin palillos DUERMEEE \n"  );
				sinpalillo.await();


			} catch (InterruptedException e) {}

		}


		System.out.println ("Filosofo "+ idfilosofo + " : Toma palillos " + idfilosofo + " y "+ (idfilosofo+1)%5 );


		lock.unlock();

	}


	public void soltarPalillo (int idfilosofo){
		lock.lock();


		int [] disparo = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

		//calcuo del disparo Soltar Palillo (t5,t6,t7,t8,t9) respectivamente para los filosofos (0,1,2,3,4)

		for(int i=0; i<15; i++){        

			if (i==(idfilosofo+5))
				disparo[i]=1;
			else 
				disparo[i]=0;
		}

		procesador.disparar(disparo);

		System.out.println ("Filosofo "+ idfilosofo + " : Deja palillos " + idfilosofo + " y "+ (idfilosofo+1)%5 );

		/** Se asume que los filosofos una vez soltados los palillos se van a pensar automaticamente
		 *  por los que se calcula la transicion de pensar a continuacion de  haber disparo la 
		 * transicion de  soltar palillos
		 */

		// calculo del disparo Pensar (t10,t11,t12,t13,t14) 

		for(int i=0; i<15; i++){        

			if (i==(idfilosofo+10))
				disparo[i]=1;
			else 
				disparo[i]=0;
		}


		procesador.disparar(disparo);

		sinpalillo.signal();
		lock.unlock();	

	}


}