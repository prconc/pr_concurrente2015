
public class Buffer //Buffer donde el productor coloca lo que produce y el consumidor saca lo que consume
{
	int maximo;
	int posicion;
	int buffer[];

	public Buffer(int max)
	{
		maximo = max;
		buffer = new int[maximo];
		posicion = -1;
	}
	
	synchronized public void agregar(int n)
	{
		if(posicion < maximo-1) //Verifica que no este lleno el buffer, sino espera
		{
			posicion++;
			System.out.println("Se agrego en la posicion " + posicion + " el numero: " + Thread.currentThread().getName());
			buffer[posicion] = n;
			notify();
		}
		else
		{
			try
			{
				System.out.println("El buffer esta lleno, el hilo " + Thread.currentThread().getName() + " esta en espera...");
				wait();
				agregar(n);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	synchronized public int quitar()
	{
		if(posicion > -1) //Verifica que no este vacio el buffer, sino espera
		{
			System.out.println("Se quito en la posicion " + posicion + " el numero: " + Thread.currentThread().getName() + ": " + buffer[posicion]);
			posicion--;
			notify();
			return buffer[posicion+1];
		}
		else
		{
			try
			{
				System.out.println("El buffer esta vacio, el hilo " + Thread.currentThread().getName() + " esta en espera...");
				wait();
				quitar();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			return -1;
		}
	}
}
