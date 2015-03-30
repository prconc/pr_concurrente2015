
public class Palillo {
	boolean libre;
	int indice;
	Palillo(int num){indice=num; libre=true;}
	
	synchronized public void agarrar()
	{
		while(!libre)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		libre = false;
	}
	synchronized public void soltar()
	{
		libre = true;
		notifyAll();
	}
	synchronized boolean isLibre()
	{
		return libre;
	}
	public int getIndice(){return indice;}
}
