import java.util.Random;

/**
 * @author joaquin
 *
 */
public class productor implements Runnable {
	
	buffer b;
	
	public productor(buffer c) {
		b=c;
		//dato=randInt(0, 9);
		}

	@Override
	public void run() {
		//El productor añade datos mientras no esté en wait().
		try{b.producir(randInt(0,9));}
		catch (Exception e) {e.printStackTrace();}
		buffer.print("Éste thread se va a dormir 100 ms");
		try {
			Thread.currentThread();
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		buffer.print("Éste thread se despertó y se fue nomas..");
		
		//b.print("Se añadio un dato");
		return;
	}
	
	//Entero random entre max y min.
	public static int randInt(int min, int max) {
		Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	    }

}