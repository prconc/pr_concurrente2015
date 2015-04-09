//Estructura de semáforo
public class Semaforo {

	int cont;
	
	public Semaforo(int contador){
		this.cont = contador;
	}
	
	//Sólo descuenta cuando hay algo para descontar.
	synchronized public void WAIT(){
		while(cont <= 0){
			try {wait();}
			catch (InterruptedException e) {e.printStackTrace();}
		}
		
		cont--;
	}
	
	synchronized public void SIGNAL(){
		cont++;
		notify();
	}
}