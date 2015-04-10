
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Filosofo f[] = new Filosofo[5];
		Palillo palillos[] = new Palillo[5];
		Contador contador;
		int numFil=5;

	
	
		contador = new Contador (numFil-1);
		
		for (int i=0; i<numFil;i++){
			palillos[i] = new Palillo();
		}
		
		for (int i=0; i<numFil;i++){
			f[i]=new Filosofo (i, contador, palillos[i], palillos[(i+1)%numFil]);
			Thread p = new Thread(f[i]);
			p.start();
		}
	}

}
