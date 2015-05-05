public class Buffer {
private boolean hayEscritor ;
private int n;

public Buffer ()
{
 hayEscritor = false;
n = 0;
}
public void escribir(int i) throws InterruptedException
{
	synchronized(this){
		while(hayEscritor || (n>0))
		{
			wait();
		}
		hayEscritor = true;
	}
	synchronized(this){
		hayEscritor = false;
		notifyAll();
	}
}
public void leer(){
	synchronized(this){
		while(hayEscritor)
			try{
				wait();
			} catch (Exception e) {}
		n++;
	}
	synchronized(this){
		n--;
		if (n==0) { 
			notifyAll();
		}
	}
}
}