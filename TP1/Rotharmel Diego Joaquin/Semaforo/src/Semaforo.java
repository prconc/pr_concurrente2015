public class Semaforo {
	protected int __contador__ = 0;
	
	public Semaforo(int inicial){
		__contador__ = inicial;
	}
	
	public synchronized void WAIT(){
		while(__contador__ == 0){
			try{
				wait();
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		__contador__--;
	}
	
	public synchronized void SIGNAL(){
		__contador__++;
		notifyAll();
	}
}
