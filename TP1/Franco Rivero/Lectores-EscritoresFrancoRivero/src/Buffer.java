public class Buffer {
private boolean hayEscritor ;
private int n;
private int max;
private int[] vector;

public Buffer (int max)
{
 hayEscritor = false;
this.max = max;
vector = new int[max];
n = 0;
}
public void escribir(int i,int j) throws InterruptedException
{
	synchronized(this){
		while(hayEscritor || (n>0))
		{
			wait();
		}
		hayEscritor = true;
	}
	if(max>j)
	{
		vector[j] = i;
	}
	synchronized(this){
		hayEscritor = false;
		notifyAll();
	}
}
public int leer(int i){

	synchronized(this){
		while(hayEscritor)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			n++;
		}
	}
		int v = vector[i];
	
	synchronized(this){
	n = n-1;
	if(n == 0)
	{
		notifyAll();
	}
	}
	return v;
	}
}