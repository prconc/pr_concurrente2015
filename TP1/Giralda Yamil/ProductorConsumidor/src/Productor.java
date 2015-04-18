
public class Productor implements Runnable {
	private Buffer buff;
	private Semaforo vacio;
	private Semaforo lleno;
	private Semaforo mutex;
	public Productor(Buffer a, Semaforo b, Semaforo c, Semaforo d){
		buff=a;
		vacio=b;
		lleno=c;
		mutex=d;
	}
	
	public void run(){
	
		while(true){
			try{
				vacio.WAIT();
				mutex.WAIT();
				buff.incrementar();
				Thread.sleep(500);
				mutex.SIGNAL();
				lleno.SIGNAL();
			}
			catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
									
		}
	}
}