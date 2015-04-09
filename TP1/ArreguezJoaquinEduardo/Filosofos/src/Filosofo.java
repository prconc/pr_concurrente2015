
public class Filosofo implements Runnable {
	
	Palito der;
	Palito izq;
	int posicion;

	
	public Filosofo(int posicion,Palito izq,Palito der) {
		
		this.der = der;
		this.izq = izq;
		this.posicion=posicion;
		
	}

	
	@Override
	public void run() {
		
		try {
			System.out.println("Filosofo "+posicion+" pensando");
			Thread.sleep(500);
			}
		catch (InterruptedException e) {e.printStackTrace();}
		
		try {
			der.agarrar();
			izq.agarrar();
			System.out.println("Filosofo "+posicion+" agarró los palillos "+izq.posicion+" y "+der.posicion);
			}
		catch (Exception e){e.printStackTrace();}
		
		try {
			System.out.println("Filosofo "+posicion+" comiendo");
			Thread.sleep(200);
			}
		catch (InterruptedException e) {e.printStackTrace();}
		
		System.out.println("Filosofo "+posicion+" dejó los palillos "+izq.posicion+" y "+der.posicion);
		der.soltar();
		izq.soltar();
		
	}
	
	
}
