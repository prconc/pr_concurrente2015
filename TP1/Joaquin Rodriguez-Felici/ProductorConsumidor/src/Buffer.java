public class Buffer 
{
	private int[] buffer;
	private int contador;
	private int tamanio;
	
	public Buffer()
	{
		tamanio = 100;					//Tamaño del buffer
		buffer = new int[tamanio];		//Inicialización del buffer
		contador = -1;
	}
	
	public synchronized void agregar(int numero)
	{

		if(contador<tamanio-1)			//Si el buffer no está lleno		
		{
			contador++;					//Se incrementa el contador
			buffer[contador] = numero;	//Se guarda el numero en la posición
			System.out.println("(" + (contador+1) + ") El hilo " + Thread.currentThread().getName() + " agregó el numero " + numero);
			notify();					//Se avisa a los consumidores que ya hay elementos para quitar
		}
		else							//En caso contrario
		{
			try
			{
				System.out.println("El hilo " + Thread.currentThread().getName() + " está esperando para agregar...");
				wait();					//Se espera a que algun consumidor haya quitado elementos para poder agregar
				agregar(numero);		//Cuando lo despiertan, intenta agregar el numero nuevamente
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public synchronized int quitar()
	{ 
		if(contador>=0)
		{
			contador--;
			System.out.println("(" + (contador+1) + ") El hilo " + Thread.currentThread().getName() + " quitó el numero el numero " + buffer[contador+1]);
			notify();
			return buffer[contador+1];
		}
		else
		{
			try
			{
				System.out.println("El hilo " + Thread.currentThread().getName() + " está esperando para quitar...");
				wait();
				return quitar();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
				return -1;
			}
		}
	}
}