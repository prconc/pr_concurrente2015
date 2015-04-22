public class Palillo {
	boolean disponible;
	
	public Palillo(){
		disponible = true;
	}
	
	public synchronized void agarrar(int filosofo){
		if(!disponible){
			try{
				wait();
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		disponible = false;
	}
	
	public synchronized void soltar(){
		disponible = true;
		notifyAll();
	}
}
