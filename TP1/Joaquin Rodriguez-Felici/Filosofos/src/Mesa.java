
public class Mesa 
{
	private boolean[] palillos;
	
	/*
	 * La mesa consta de 5 palillos, representado por un arreglo de 5 booleanos.
	 * Cuando el elemento palillos[i] está en false, significa que el palillo
	 * está siendo utilizado para comer.
	 */
	
	public Mesa()
	{
		palillos = new boolean[5];
		
		for(int i=0; i<5; i++)
		{
			palillos[i] = true;
		}
	}
	
	public synchronized boolean comprobar(int i)
	{
		return palillos[i];
	}
	
	public synchronized void set(int i, boolean b)
	{
		palillos[i] = b;
	}
	
	public synchronized int getCantidadPalillos()
	{
		int count = 0;
		
		for(int i=0; i<5; i++)
		{
			if(palillos[i])
			count++;
		}
		return count;
	}
}
