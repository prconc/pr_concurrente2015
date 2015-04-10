public class Semaforo {

	private int contador;
	
	public Semaforo(int contador){
		this.contador = contador;
	}
	
	synchronized public void Wait(){
		while(contador == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		contador--;
	}
	
	synchronized public void Signal(){
		contador++;
		notify();
	}
}
