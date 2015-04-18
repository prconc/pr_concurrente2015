
public class Semaforo {
	private int lleno;
	private boolean stop;

	public Semaforo(int a)
	{
		lleno=a;
	}

	public synchronized void WAIT()
	{
		while( lleno==0 ){	  
			try {
				wait();
				stop=true;
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
		stop=false;
	}
	public boolean get_stop()
	{
		return stop;
	}
}