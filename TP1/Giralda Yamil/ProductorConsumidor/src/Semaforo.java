
public class Semaforo {
	private int lleno;

	public Semaforo(int a)
	{
		lleno=a;
	}

	public synchronized void WAIT()
	{
		while( lleno==0 ){	  
			try {
				wait();
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		lleno=lleno-1;    
	}		
	
	public synchronized void SIGNAL() 
	{
		lleno=lleno+1;
		notifyAll();	
	}
}