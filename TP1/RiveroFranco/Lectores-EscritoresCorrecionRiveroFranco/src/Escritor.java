
public class Escritor implements Runnable {
	int n;
	Buffer b;
	
	public Escritor(Buffer B, int N){
		b = B;
		n = N;		
	}
	
	public void run(){
		int i=0;
		while (i<10){
			System.out.println("Escritor "+ n + " quiere escribir");
			try {
				b.escribir(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Escritor "+ n + " ha terminado");
			i++;
		}
	}

}
