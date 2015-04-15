
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Semaforo w1=new Semaforo(1);
		Semaforo m2=new Semaforo(1);
		
		Escritor e1=new Escritor(w1,1);
		Escritor e2=new Escritor(w1,2);
		
		Lector l1=new Lector(w1,m2,1);
		Lector l2=new Lector(w1,m2,2);
		Lector l3=new Lector(w1,m2,3);
		
		Thread hilo1=new Thread(e1);
		Thread hilo2=new Thread(e2);
		Thread hilo3=new Thread(l1);
		Thread hilo4=new Thread(l2);
		Thread hilo5=new Thread(l3);
		
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();
		
		

	}

}
