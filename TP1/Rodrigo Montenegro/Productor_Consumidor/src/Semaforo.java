
public class Semaforo {

	int recurso;
	
	
	public Semaforo(int r){
		recurso=r;
		
		
	}
	
	public synchronized void WAIT(){
	
		while(recurso==0){
			
			try {
				
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		recurso--;
		
	}
	
	public synchronized void SIGNAL(){
		
		recurso++;
		notifyAll();
		
		
	}
}
