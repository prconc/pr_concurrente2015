
public class Main {

	public static void main(String[] args) {
		Buffer buff=new Buffer();
		Semaforo Lleno=new Semaforo(0);
		Semaforo Vacio=new Semaforo(10);
		Semaforo Mutex=new Semaforo(1);
		Productor prod1=new Productor(buff,Vacio,Lleno,Mutex);
		Productor prod2=new Productor(buff,Vacio,Lleno,Mutex);
		Consumidor cons1=new Consumidor(buff,Vacio,Lleno,Mutex);
		Consumidor cons2=new Consumidor(buff,Vacio,Lleno,Mutex);
		
		Thread hilo1=new Thread(prod1);
		Thread hilo2=new Thread(prod2);
		Thread hilo3=new Thread(cons1);
		Thread hilo4=new Thread(cons2);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		
	}

}