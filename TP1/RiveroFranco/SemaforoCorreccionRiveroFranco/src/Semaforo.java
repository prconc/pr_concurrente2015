
public class Semaforo {
private int n;

public Semaforo(int n)
{
	this.n = n;
}
synchronized public void WAIT()
{
	while (n == 0 )
	{
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		n = n-1;
	}
}
synchronized public void SiGNAL()
{
		n++;		
  notifyAll();
}
}