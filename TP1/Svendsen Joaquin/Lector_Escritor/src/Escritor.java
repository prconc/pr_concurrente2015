
public class Escritor implements Runnable{
	
	Semaforo_mutex mutex;
	Seccion_critica compartir;
	
	public Escritor(Semaforo_mutex mu,Seccion_critica m){
	
		mutex=mu;
		compartir=m;
		
	}
	
	public void run(){
		
		while(true){
		
			mutex.WAIT();
			compartir.escribiendo();
			System.out.println("Dejando de escribir \n");
			mutex.SIGNAL();
			
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}
}
