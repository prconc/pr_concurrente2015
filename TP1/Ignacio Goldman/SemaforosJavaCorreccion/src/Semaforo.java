public class Semaforo {
	protected int senal = 0;
	
	Semaforo(int senal){this.senal = senal;}
	
	synchronized public void WAIT(int v)
	{
		while(senal < v)
		{
			try {
				wait();
			} catch (InterruptedException e) {e.printStackTrace();}
		}
		senal--; 
		;
		
	}
	synchronized public void SIGNAL()
	{
		senal++;
		notify();
	}
	
}
