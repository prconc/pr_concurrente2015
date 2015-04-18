
public class Filosofo implements Runnable {
	private int id;
	private Semaforo palillo1;
	private Semaforo palillo2;
	private Semaforo sitio;
	Filosofo(int a,Semaforo b,Semaforo c,Semaforo d)
	{
		id=a;
		palillo1=b;
		palillo2=c;
		sitio=d;
	}
	public void run(){
		
		while(true){
			try {
			System.out.println("Filosofo[" + id +  "] Pensando");
			Thread.sleep(500);
			sitio.WAIT();
			palillo1.WAIT();
			palillo2.WAIT();
			System.out.println("Filosofo[" + id +  "] Comiendo");
			palillo1.SIGNAL();
			palillo2.SIGNAL();
			sitio.SIGNAL();
		
			}
			catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}