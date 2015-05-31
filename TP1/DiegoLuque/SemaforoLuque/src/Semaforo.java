
public class Semaforo {
	int contador = 0;	
	public Semaforo(int c){
		contador = c;
	}
	
	synchronized public void WAIT(){	
		if(contador == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		contador--;
	}
	
	synchronized public void SIGNAL(){
		contador++;
		notify();
	}
}
