
public class Palillo {
	
	boolean disponible;
	
	public Palillo(){
		disponible = true;
	}

	
	synchronized public void agarrar(){
		if(!disponible){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		disponible = false;
		
	}
		
	synchronized public void soltar(){
	
		
		disponible = true;
		notifyAll();
			
	}

}
