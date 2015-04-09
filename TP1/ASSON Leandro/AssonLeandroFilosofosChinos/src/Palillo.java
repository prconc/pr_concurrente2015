
public class Palillo
{
	
private boolean libre;
private int indice;
	
	public Palillo(int indice)
	{
		this.indice=indice;
		libre=true;
		
	}
	//Agarra el palillo si esta libre, mientras este ocupado espera.
	synchronized public void agarrar(int quien)
	{
		while(!libre)
		{
			try
			{
				wait();	
			}
			catch(Exception e){}
			
		}
		
		libre=false;
	}
	//suelta el palillo.
	synchronized public void soltar()
	{
	libre=true;
	notifyAll();
	}
	
	public int getindice()
	{
	return indice;	
	}
}
 