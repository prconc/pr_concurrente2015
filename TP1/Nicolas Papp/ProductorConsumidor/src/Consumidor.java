

public class Consumidor implements Runnable {
	Buffer b;
	Consumidor(Buffer buffer) {
		b = buffer;
	}
	public void run() {
		// TODO Auto-generated method stub
		b.consumir();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
