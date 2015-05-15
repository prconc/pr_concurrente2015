import java.util.concurrent.TimeUnit;


public class Recurso {
	
	int numLectores = 0;
	boolean hayEscritor = false;
	
	public Recurso() {
		
	}
	
	public void leer() {
		synchronized (this) {
			while(hayEscritor)
				try {
					wait();
				} catch (Exception e) {}
			numLectores++;
		}
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		synchronized (this) {
			numLectores--;
			if(numLectores == 0) notifyAll();
		}
	}
	
	synchronized public void escribir() {
		synchronized(this) {
			while(hayEscritor || (numLectores > 0))
				try {
					wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			hayEscritor = true;
		}
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized (this) {
			hayEscritor = false;
			notifyAll();
		}
	}
	
}
