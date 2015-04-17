
public class Lector implements Runnable{
	
	
	Semaforo_mutex mutex;
	
	Seccion_critica compartir;
	

	public Lector(Semaforo_mutex mux,Seccion_critica m){
		
		mutex=mux;
		compartir=m;
		
	}
	
	
	public void run(){
		
		while(true){
			mutex.WAIT();
			compartir.leyendo();
			System.out.println("Dejando de leer \n");
			mutex.SIGNAL();
			
	}
		
	}
	
	
}
