
public class Contador {
	
	private int maximo;
	private int contador;
	
	public Contador(int maximo) {
		this.maximo = maximo;
		contador = 0;
	}
	
	synchronized public void incr() {
		
		while(contador == maximo) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		contador++;		
	}
	
	synchronized public void decr() {
		
		contador--;
		notifyAll();
	}
}
