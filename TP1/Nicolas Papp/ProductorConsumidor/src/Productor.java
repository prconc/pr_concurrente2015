import java.util.Random;

public class Productor implements Runnable {	//Se inicializa y después de eso solo intenta producir datos
	Buffer b;
	Random rnd;
	Productor(Buffer buffer) {
		b = buffer;
		rnd = new Random();
	}
	public void run() {
		// TODO Auto-generated method stub
		int i = (rnd.nextInt()%10);
		b.producir(i);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
