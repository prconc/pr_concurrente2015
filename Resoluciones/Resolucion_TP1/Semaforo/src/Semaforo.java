
public class Semaforo {
	
	protected int contador = 0;
	
	public Semaforo (int contador) {
		this.contador = contador;
	}
	
	synchronized public void WAIT () {
		
		while (this.contador == 0) {
			try {
				this.wait();	
			} catch (Exception e) {}
		}
			this.contador--;
		
	}
	
	
	synchronized public void SIGNAL() {
		this.contador++;
		notifyAll();
	}
}
