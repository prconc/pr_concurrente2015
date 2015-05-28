
public class MainFilosofos {
	Filosofo f[] = new Filosofo[5];
	Palillo palillos[]= new Palillo [5];
	Contador contador;
	int numFil= 5;
	
	public MainFilosofos (){
		contador = new Contador (numFil -1);
		
		for (int i=0; i<numFil;i++) {
			palillos[i]= new Palillo();
		}
		
		for (int i=0; i < numFil; i++) {
			f[i]= new Filosofo (i, contador, palillos[i],palillos[(i+1)%numFil]);
			f[i].start();
		}
		
		for(int i=0; i<numFil;i++) {
			try {
				f[i].join(); //espera al resto de filosofos
			}catch (Exception e) {}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFilosofos();
	}

}
