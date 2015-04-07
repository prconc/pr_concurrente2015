import java.util.Random;

public class Filosofo implements Runnable {
	
	private String nombre;
	private Palillo pIzq;
	private Palillo pDer;
	private Contador contador;
	private int vecesComidas;
	
	public Filosofo(String nombre, Palillo pIzq, Palillo pDer, Contador contador) {
		
		this.nombre = nombre;
		this.pIzq = pIzq;
		this.pDer = pDer;
		this.contador = contador;
		vecesComidas = 0;
	}
	
	public void run() {
		
		while(true) {
			System.out.println(nombre+" quiere comer.");
			contador.incr();
			pIzq.tomar();
			pDer.tomar();
			System.out.println(nombre+" esta comiendo.");
			try {
				Random rand = new Random();
				Thread.sleep(rand.nextInt(2000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pIzq.soltar();
			pDer.soltar();
			contador.decr();
			vecesComidas++;
			System.out.println(nombre+" comio "+vecesComidas+" veces.");
			try {
				Random rand = new Random();
				Thread.sleep(rand.nextInt(3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
