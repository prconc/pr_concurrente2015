
public class Main {

	/**
	 * @param args
	 */
	
	static int cantidadFilosofos = 5;
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//se crean dos vectores, uno de 5 filosofos y el otro de 5 palillos
		Filosofo filosofos[] = new Filosofo[cantidadFilosofos];
		Palillo palillos[] = new Palillo[cantidadFilosofos];
		
		
		
		Contador contador= new Contador(cantidadFilosofos-1);
		
		for(int i = 0; i < cantidadFilosofos; i++){
			
			palillos[i] = new Palillo();
			
		}
		
		//se asignan a cada filosofo dos palillos, el de su derecha y el de su izquierda
		for(int i = 0; i< cantidadFilosofos; i++){
			
			filosofos[i] = new Filosofo(i, palillos[i], palillos[(i+1)%cantidadFilosofos], contador);
			Thread t = new Thread(filosofos[i]);
			t.start();
			
		}

	}

}
