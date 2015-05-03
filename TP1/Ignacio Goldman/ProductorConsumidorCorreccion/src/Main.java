
public class Main {

	public static void main(String[] args) {
		Buffer b = new Buffer(10);
		
		for(int i=0;i<10;i++){
		Productor p = new Productor(i,b);
		Consumidor c = new Consumidor(b);
		
		Thread hilo1 = new Thread(p);
		Thread hilo2 = new Thread(c);
		
		hilo1.start();
		hilo2.start();
		}
	}

}
