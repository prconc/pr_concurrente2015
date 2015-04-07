import java.util.Random;

public class Consumidor implements Runnable {
	
	private Buffer buffer;
	
	public Consumidor(Buffer buffer) {
		
		this.buffer = buffer;
	}
	
	public void run() {
		
		while(true) {
			buffer.consumir();
			try {
				Random rand = new Random();
				Thread.sleep(rand.nextInt(3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
