
public class Main {
	
	public static void main(String arg[]){
		
	Semaforo_mutex mutex= new Semaforo_mutex();
	Seccion_critica compartido=new Seccion_critica();
	
	
	
	Lector l1=new Lector(mutex,compartido);
	Lector l2=new Lector(mutex,compartido);
	Lector l3=new Lector(mutex,compartido);
	
	Escritor e1=new Escritor(mutex,compartido);
	Escritor e2=new Escritor(mutex,compartido);
	
	

	
	Thread hilo1=new Thread(l1);	
	Thread hilo2=new Thread(l2);
	Thread hilo3=new Thread(l3);
	Thread hilo4=new Thread(e1);
	Thread hilo5=new Thread(e2);
	
	hilo1.start();
	hilo2.start();
	hilo3.start();
	hilo4.start();
	hilo5.start();

	
	}
}
