
public class Semaforo {
	
	private int cant;

	public Semaforo(int c) {
		// TODO Auto-generated constructor stub
		cant=c;
	}
	synchronized public void Wait(){
		while(cant==0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cant--;
	}
	
	synchronized public void Signal(){
		cant++;
		notifyAll();
	}

}
