import java.util.Random;

public class Productor implements Runnable {
	
	private Buffer buffer;
	
	public Productor(Buffer buffer) {
		
		this.buffer = buffer;
	}
	
	public void run() {
		
		while(true) {
			buffer.producir();
			try {
				Random rand = new Random();
				Thread.sleep(rand.nextInt(2000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
