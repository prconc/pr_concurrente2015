
public class Main {

	public static void main(String[] args) {
		Buffer b = new Buffer(10);
		Productor p = new Productor(5,b);
		Consumidor c = new Consumidor(b);
		
		Thread hilo1 = new Thread(p);
		Thread hilo2 = new Thread(c);
		
		hilo1.start();
		hilo2.start();
	}

}
