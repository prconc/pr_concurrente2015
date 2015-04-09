
public class Buffer {
	int tamaño;
	int numLectores;
	int buffer[];
	boolean escribiendo;
	
	public Buffer(int tamaño)
	{
		buffer = new int[tamaño];
		numLectores = 0;
		this.tamaño = tamaño;
		escribiendo = false;
		
	}
	
	public int leer(int indice)
	{
		synchronized (this)
		{
			while (escribiendo)
			{
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
					
				}
				
				numLectores++;
			}
					
		}
			
		int dato = buffer[indice];
		
		synchronized (this)
		{
			numLectores--;
			if(numLectores == 0)
				notifyAll();
		}
	return dato;	
		
	}
	
	public void escribir(int dato, int indice)
	{
		synchronized (this) 
		{
			while(escribiendo || (numLectores>0))
			{
				try {
					wait();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
			}
			escribiendo = true;
			
		}
		
		if(tamaño > indice) buffer[indice] = dato;
	
	
		synchronized(this)
		{
			escribiendo = false;
			notifyAll();
		}
	
	}
	
}
