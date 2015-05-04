public class Mesa 
{
	private boolean[] palillos; //La mesa tiene de 5 palillos, representado por un arreglo de 5 booleanos
								
	public Mesa()
	{
		palillos = new boolean[5];
		
		for(int i=0; i<5; i++)
		{
			palillos[i] = true; //Se inicializan como disponibles todos los palillos
		}
	}
	
	public synchronized boolean get_disponible(int i)
	{
		return palillos[i];
	}
	
	public synchronized void set_disponible(int i, boolean b)
	{
		palillos[i] = b;
	}
}