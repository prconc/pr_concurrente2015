/**
 * 
 */

/**
 * @author Carlos
 *
 */
public class Semaforo {
	private int contador = 0;
	private boolean binario=false;
	private String name;
	public String getName() {
		return name;
	}

	public Semaforo (int contador,boolean binario, String name) {
		this.contador = contador;
		this.name =name;
		this.binario=binario;
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
		if(binario)
			this.contador=1;
		else {
			this.contador++;
		}
		notify();
	}
}
