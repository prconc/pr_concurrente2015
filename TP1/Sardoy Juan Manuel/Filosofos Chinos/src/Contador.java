
public class Contador {
	
	int cuenta;
	int max;
	
	
	//la clase contador sirve para asegurar que solo 4 de los 5 filosofos hagan el intento de comer
	// lo que asegura que al menos uno va a tener disponible los dos palillos, y podra comer
	public Contador(int max){
		this.max = max;
	}
	
	
	//si la cuenta esta en 4, el quinto filosofo tendra que esperar a que alguno de los demas termine
	// de comer y la decremente.
	synchronized public void incrementar(){
		if(cuenta == max){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cuenta++;
		
	}
	
	synchronized public void decrementar(){
	
		cuenta--;
		notifyAll();
		
	}

}
