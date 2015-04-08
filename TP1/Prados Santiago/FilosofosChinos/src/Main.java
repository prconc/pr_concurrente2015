

public class Main {
	/**
	 * ---------------------------------------------
	 * |       FILOSOFOS CHINOS                    |
	 * ---------------------------------------------
	 * EXisten 5 filosofos que se pasan el tiempo pensando y comiendo . Cuando no piensan comen y viceversa
	 * Los  filosofos comen en una mesa redonda que tiene 5  sillas y 5 platos . 
	 * La mesa tienen  un total de 5 cubiertos y cada filosofo necesito si  o si  2 cubiertos  para comer por lo
	 * tanto , No puede haber mas de 2 filosofos comiendo al mismo tiempo 
	 * Mientras dos comen los otros piensan hasta que sea su turno de comer.
	 * Se utilizan numero aleatorios para decir que palillo intenta toma el filosofo (el de su derecha o el de su izquierda),para el tiempo que pasa pensando el filosofo y 
	 * tambien para determinar el tiempo de espera que pasara un filosofo con un palillo en la mano hasta que lo deje libre si no puede tomar el otro 
	 * cuando un filosofo termina de comer o cuando no puede acceder a los dos palillos ,suelta los palillos y se pone a pensar  
	 */

	public static void main(String[] args) {



		Palillo  palillo [] = new Palillo[5];
		Filosofo filosofo[]=new Filosofo[5];

		// Creo 5 palillos
		for (int i =0 ; i<5;i++){


			palillo [i] = new Palillo (i);
		}


		//Creo 5 filosofos


		filosofo [0] = new Filosofo (0,palillo[0],palillo[1]);
		filosofo [1] = new Filosofo (1,palillo[1],palillo[2]);
		filosofo [2] = new Filosofo (2,palillo[2],palillo[3]);
		filosofo [3] = new Filosofo (3,palillo[3],palillo[4]);
		filosofo [4] = new Filosofo (4,palillo[4],palillo[0]);

		//comienza la ejecucion de los filosofos 
		filosofo [0].start();
		filosofo [1].start();
		filosofo [2].start();
		filosofo [3].start();
		filosofo [4].start();

	}

}
