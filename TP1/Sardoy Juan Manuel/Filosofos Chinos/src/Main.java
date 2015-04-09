
public class Main {

	/**
	 * @param args
	 */
	
	static int cantidadFilosofos = 5;
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Filosofo filosofos[] = new Filosofo[cantidadFilosofos];
		Palillo palillos[] = new Palillo[cantidadFilosofos];
		
		
		
		Contador contador= new Contador(cantidadFilosofos-1);
		
		for(int i = 0; i < cantidadFilosofos; i++){
			
			palillos[i] = new Palillo();
			
		}
		
		for(int i = 0; i< cantidadFilosofos; i++){
			
			filosofos[i] = new Filosofo(i, palillos[i], palillos[(i+1)%cantidadFilosofos], contador);
			Thread t = new Thread(filosofos[i]);
			t.start();
			
		}

	}

}
