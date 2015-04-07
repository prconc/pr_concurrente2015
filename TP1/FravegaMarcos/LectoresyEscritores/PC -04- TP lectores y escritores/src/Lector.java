import java.util.Random;

public class Lector implements Runnable {

	private Buffer buffer;
	private int id;
	
	public Lector(Buffer buffer, int id) {
		
		this.buffer = buffer;
		this.id = id;
	}
	
	public void run() {
		
		int i = 1;
		
		while(i<17) {
			System.out.println("El lector "+id+" quiere leer.");
			buffer.leer();
			System.out.println("El lector "+id+" leyo "+i+" datos.");
			try {
				Random rand = new Random();
				Thread.sleep(rand.nextInt(3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
}
