
public class Palillo {
	
	private boolean libre;
	
	public Palillo() {
		
		libre = true;
	}
	
	synchronized public void tomar() {
		
		while(!libre) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		libre = false;		
	}
	
	synchronized public void soltar() {
		libre = true;
		notifyAll();		
	}
}
