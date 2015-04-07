import java.util.Random;

public class Escritor implements Runnable {
	
	private Buffer buffer;
	private int id;
	
	public Escritor(Buffer buffer, int id) {
		
		this.buffer = buffer;
		this.id = id;
	}
	
	public void run() {
		
		boolean lleno = false;
		
		while(true) {
			System.out.println("El escritor "+id+" quiere escribir.");
			lleno = buffer.escribir(id);
			
			if (!lleno) {
				try {
					Random rand = new Random();
					Thread.sleep(rand.nextInt(3000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				break;
			}
		}		
	}
}
