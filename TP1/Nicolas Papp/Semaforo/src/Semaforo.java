
public class Semaforo {
	int s;
	int blocked;
	
	Semaforo(int v){s=v; blocked=0;}
	
	synchronized public void WAIT()
	{
		while(s<=0)
		{
			try {
				blocked++;
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		s--;
		blocked--;
	}
	synchronized public void SIGNAL()
	{
		if(blocked == 0)
			s++;
		
		notify();
	}
	
}
