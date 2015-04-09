
public class Semaforo {
private int n;
private int i;

public Semaforo(int n)
{
	this.n = n;
	i = 0;
}
synchronized public void WAIT()
{
	while (n == 0 )
	{
		try {
			wait();
			i++;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	n = n-1;
	i = i-1;
}
synchronized public void SiGNAL()
{
	if(i == 0)
		n++;
		
  notify();
}
}
