public class Main {
	public static void main(String[] args) {
		Filosofo filosofos[] = new Filosofo[5];
		Palillo palillos[] = new Palillo[5];
		Contador contador;
		int numFilosofos = 5;
		
		contador = new Contador(numFilosofos -1);
		
		for(int i = 0 ; i < numFilosofos ; i++){
			palillos[i] = new Palillo();
		}
		
		for(int i = 0 ; i < numFilosofos ; i++){
			filosofos[i] = new Filosofo(i, contador, palillos[i], palillos[(i+1)%numFilosofos]);
			Thread p = new Thread(filosofos[i]);
			p.start();
		}
	}
}
