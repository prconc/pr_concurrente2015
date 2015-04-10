
public class Recurso { 
	int numLectores = 0;
	boolean hayEscritor = false;
	
	public void leer()
	{
		synchronized (this)
		{
			while (hayEscritor)
				try	{
					wait();
				}catch(Exception e) {}
			numLectores++;
		}
		
		synchronized (this)
		{
			numLectores--;
			if(numLectores == 0) 
			notifyAll(); 
		}
	}
	
	synchronized public void escribir()
	{
		synchronized (this)
		{
			while (hayEscritor || (numLectores > 0))
				try{
					wait();
				}catch (Exception e) {e.printStackTrace();}
			hayEscritor = true;
		}
	
		synchronized (this)
		{
			hayEscritor = false;
			notifyAll();
		}
	}
}
