
public class Semaforo {
    private int s;
	public Semaforo(int b){
		s=b;

	}
	public synchronized void stop() {
		while(s==0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}          

		}
		
		s=s-1;
					
		}		
	public synchronized void signal() {
			s=s+1;
			notifyAll();     
						
		}
}

