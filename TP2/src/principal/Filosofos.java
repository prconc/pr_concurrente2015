package principal;

import java.util.Random;

import logica.Monitor;


public class Filosofos extends Thread {


	private int idfilosofo;
	private Random random;
	private Monitor mon ;



	public Filosofos (int idfilosofo_,Monitor moni){

		idfilosofo=idfilosofo_ ;
		mon=moni;
		random = new Random () ;
	}


	public void pensar () {

		// se determina un tiempo aleatorio  que el filosofo pasara pensando 

		try {

			System.out.println ("Filosofo "+ idfilosofo + " : PENSANDO ");
			Thread.sleep(random.nextInt(300)) ;

		} catch (InterruptedException e) {

			e.printStackTrace();
		}



	}



	public void comer (){

		mon.obtenerPalillo(idfilosofo);		

		System.out.println ("Filosofo "+ idfilosofo + " : COMIENDO ");

	}


	public void soltar (){

		mon.soltarPalillo(idfilosofo);

		this.pensar();
	}




	public void run (){

		while (true){

			this.comer();
			try {


				Thread.sleep(random.nextInt(200)) ;

			} catch (InterruptedException e) {}
			this.soltar();

		}

	}



}
