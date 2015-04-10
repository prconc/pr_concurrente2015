/*Practico numero 1, problema de los filosofos, programacion concurrente 2014
 *Alumnos: Guillermo Johnston    35886421
 *         lucas     Almendros   36354785
 */
import java.util.Random;
public class Filosofo extends Thread {
	//Cada filosofo sabe cual es su palillo derecho y el izquierdo de acuerdo a su numero
	
	private int left;//palillo izquierdo
	private int right;//palillo derecho, tambien es el id del filosofo
	private Mesa m;
	
	/*le pasamos como parametro el id del filosofo(con el cual identificamos los palillos que el va a usar)
	  , el numero de palollos(que tambien es el numero de filosofos) y la mesa
	*/
	public Filosofo(int numero,int cantidad, Mesa m) {
		// TODO Auto-generated constructor stub
		right=numero;
		
		if(numero + 1 == cantidad){
			left=0;
		}
		else{
			left = numero + 1;
		}
		System.out.println("numero: " + numero + " Right: "+ right + " Left: "+ left);
		this.m = m;
	}
	
	public void run(){
		while(true){
			leer();
			comer();
		}
	}
	
	//El filosofo lee un tiempo random
	private void leer(){
		System.out.println("Filosofo Numero: " + right + " Leyendo");
		try {
			Thread.sleep((long) (500*(new Random().nextDouble())));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//El filósofo come un tiempo random pero primero va a la mesa.
		//Cuando termina de comer simplemente deja la mesa.
	private void comer(){
		m.comer(right, left);//llama al metodo comer de mesa m para ver si el puede comer si no
		                     // el filosofo espera asta que pueda comer
		try {
			Thread.sleep((long) (500*(new Random().nextDouble())));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		m.dejarDeComer(right, left);/*el filosofo deja los palollos y repite todo 
		                              el proceso para volver comer
		                            */
		
	}
	

}