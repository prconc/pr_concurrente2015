/*Practico numero 1, problema de los filosofos, programacion concurrente 2014
 *Alumnos: Guillermo Johnston    35886421
 *         lucas     Almendros   36354785
 */
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
		//Cantidad de palillos y filósofos.
		int cantidad = 5;
		Semaforo s= new Semaforo();
		Mesa mesa = new Mesa(cantidad, s);
		
		//Creamos los 5 filósofos.
		for(int i=0; i < cantidad; i++){
			/*Cuando creamos el filósofo, le damos un nombre(numero), le pasamos cuantos
			 * filósofos son y la clase mesa. 
			 */

			Filosofo f = new Filosofo(i, cantidad, mesa);
			f.start();
		}

	}

}
