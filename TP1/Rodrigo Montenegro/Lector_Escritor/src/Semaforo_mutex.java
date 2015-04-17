
public class Semaforo_mutex {
	
	boolean accedo;
	
	public Semaforo_mutex(){
	
		accedo=true;
	}
	
	
	public synchronized void WAIT(){
		
		while(accedo==false){
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		accedo=false;
		
	}
	
	
	public synchronized void SIGNAL(){
		
		accedo=true;
		notifyAll();
		
		
	}
	

}
