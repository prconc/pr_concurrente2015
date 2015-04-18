
public class Escritor implements Runnable {
	private int id;
	private Semaforo sesc;
	Escritor(int a,Semaforo b)
	{
		id=a;
		sesc=b;
	}
	public void run(){
		
		while(true){
			try {
			sesc.WAIT();
			System.out.println("Escritor[" + id +  "] Escribiendo");
			Thread.sleep(500);
			sesc.SIGNAL();
			}
			catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}

