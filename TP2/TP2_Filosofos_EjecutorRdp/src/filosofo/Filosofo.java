package filosofo;
import rdp.Matrix;
import monitor.Monitor;

/*Clase filosofo. Es un hilo que implementa Runnable. 
 * Los campos que posee son: Los vectores de disparo 1 y 2: El uno es el vector que indica que ese filosofo come y el otro que el filosofo
 *devuelve el palillo. Estos vectores se condicen con la RdP modelada.
 *Un objeto monitor, que es el monitor donde el filosofo ingresa a pedir los palillos.
 *Un string con el nombre del filosofo.
 */

public class Filosofo implements Runnable {
	
	Thread hiloFilosofo;
	Matrix vector_disparo1;
	Matrix vector_disparo2;
	Monitor monitor;
	String nombre;
	
	/*El constructor recibe un string con el nombre, ambos vectores de disparo, y el monitor al que se vincula el filosofo.*/
	
	public Filosofo(String nombre, Matrix vector_disparo1, Matrix vector_disparo2, Monitor monitor){
		
		this.vector_disparo1=vector_disparo1;
		this.vector_disparo2=vector_disparo2;
		this.monitor=monitor;
		this.nombre=nombre;
		hiloFilosofo = new Thread(this,nombre);
		System.out.println("Un "+nombre+" aparece.");
		hiloFilosofo.start();
	}
	
	
public void run()
{
	while(true){
		try{
		monitor.comer(vector_disparo1,nombre);							//ingresa al monitor para comer
		Thread.sleep(1);												//simula tarea
		monitor.devolver_palillo(vector_disparo2, nombre);				//ingresa al monitor para devolver palillo
		Thread.sleep(1);												//simula tarea
		} catch(InterruptedException e){}
	}
}	
}
	
