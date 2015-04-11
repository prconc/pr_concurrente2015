public class Consumidor implements Runnable {
	Buffer buffer;

	Consumidor(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {

		buffer.consumir();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
