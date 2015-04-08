

import java.util.Random;

public class Filosofo extends Thread {

	private int idfilosofo;
	private Palillo pizq;
	private Palillo pder;

	private Random random;

	private boolean pdertomado=false;
	private boolean pizqtomado=false ;

	private int elegido;




	public Filosofo (int idfilosofo_,Palillo pizq_,Palillo pder_){

		idfilosofo=idfilosofo_ ;
		pizq = pizq_ ;
		pder = pder_ ;
		random = new Random () ;
	}

	public void pensar () {

		// se determina un tiempo aleatorio  que el filosofo pasara pensando 
		
		try {

			System.out.println ("Filosofo "+ idfilosofo + " : PENSANDO ");
			Thread.sleep(random.nextInt(300)) ;
			System.out.println ("Filosofo "+ idfilosofo + " : Termino de pensar Quiere Comer ");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}



	}



	public void comer (){



		System.out.println ("Filosofo "+ idfilosofo + " : !!! COMIENDOOOOOOO !!! ");

		//Luego de comer suelta los palillos y se pone a pensar 

		pizqtomado=false;
		pdertomado=false;

		pder.soltar(idfilosofo);
		pizq.soltar(idfilosofo);

		this.pensar();
	}


	
	public void run (){

		while (true){


			//seleccion del palillo 

			elegido=random.nextInt(2);//se utiliza un random para tomar la decicion aleatoria de que palillo tomar el izquierdo (0) o el derecho (1) 

			
			
			 
			
			
			
			if (elegido == 0){

				if (!pizq.ocupado())
				{

					pizq.tomar(idfilosofo);
					pizqtomado = true ;

				}
				else if (! pder.ocupado())
				{


					pder.tomar(idfilosofo);
					pdertomado=true;

				}

			} 

			else if (elegido==1){

				if (!pder.ocupado()){

					pder.tomar(idfilosofo);
					pdertomado=true;

				}
				else if (!pizq.ocupado()){

					pizq.tomar(idfilosofo);
					pizqtomado =true;

				}
			}

			if (pdertomado && pizqtomado){ // si tiene los dos palillos tomados el filosofo come 

				this.comer();
				this.pensar();

			}
			else { //si no estan disponibles los dos palillos pero al menos 1 esta tomado espero un tiempo aleatorio y pregunto si se livero el palillo que falta 

				if( pdertomado && ! pizqtomado){ //palillo derecho tomado , palillo izquierdo sin tomar

					try {
						Thread.sleep(random.nextInt(300)); //Espero un tiempo aleatorio para ver si se libera el recurso 

					} catch (InterruptedException e) {

						e.printStackTrace();
					}

					if  (pizq.ocupado()){ // si sigue ocupado depues de esperar libero el que tengo tomado para no genererar interbloqueos

						pder.soltar(idfilosofo);
						pdertomado=false;
						this.pensar();

					}else {  //si el  palillo esta liberado lo tomo y el filosofo puede comer 
						pizq.tomar(idfilosofo);
						pizqtomado=true;
						this.comer();


					}

				}


				if( !pdertomado &&  pizqtomado){//palillo izquierdo tomado , palillo derecho sin tomar 



					try {
						Thread.sleep(random.nextInt(300));

					} catch (InterruptedException e) {

						e.printStackTrace();
					}

					if (pder.ocupado()){

						pizq.soltar(idfilosofo);
						pizqtomado=false;
						this.pensar();

					}else {
						pder.tomar(idfilosofo);
						pdertomado=true;
						this.comer();

					}


				}


			}



		}

	}
}

