
public class MainFilosofos {
	
	Filosofo f[] = new Filosofo[5];
	Palillo palillos[]= new Palillo[5];
	Contador contador;
	int numfil = 5;
	
	public MainFilosofos() {
		contador = new Contador(numfil-1);
		
		for (int i=0; i<numfil; i++){
			palillos[i] = new Palillo();
		}
		
		for (int i=0; i<numfil; i++){
			f[i] = new Filosofo(i, contador, palillos[i], palillos[(i+1)%numfil]);
			f[i].start();
		}
		
		for (int i=0; i<numfil; i++){
			try {
				f[i].join();
			} catch (Exception e) {
				
			}
			
		}

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFilosofos();
		System.out.println("Fin filosofos");
	}

}
