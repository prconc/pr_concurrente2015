import java.util.Random;

public class Productor implements Runnable {
	Buffer buffer;
	Random random;

	Productor(Buffer buffer) {
		this.buffer = buffer;
		random = new Random();
	}

	public void run() {

		int i = (random.nextInt() % 10);
		buffer.producir(i);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
