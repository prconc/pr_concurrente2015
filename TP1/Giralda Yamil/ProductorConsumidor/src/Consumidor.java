
public class Consumidor implements Runnable {
	private Buffer buff;
	private Semaforo vacio;
	private Semaforo lleno;
	private Semaforo mutex;
	public Consumidor(Buffer a, Semaforo b, Semaforo c, Semaforo d){
		buff=a;
		vacio=b;
		lleno=c;
		mutex=d;
	}
	
	public void run(){
	
		while(true){
			try{
				lleno.WAIT();
				mutex.WAIT();
				buff.decrementar();
				Thread.sleep(500);
				mutex.SIGNAL();
				vacio.SIGNAL();
			}
			catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
									
		}
	}
}