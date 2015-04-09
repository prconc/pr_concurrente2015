
public class Filosofo implements Runnable //Filosofo come en caso de que sus dos palillos esten disponibles
{                                         //Caso contrario piensa hasta que esten disponibles
	int num_filosofo;
	Palillo[] palillos;
	Palillo palilloDerecho;
	Palillo palilloIzquierdo;
	
	public Filosofo(int n, Palillo[] palillos) //Recibe el arreglo de 5 palillos y asigna el palillo izquierdo y derecho
	{                                          //Segun el numero que representa al filosofo
		num_filosofo = n;
		this.palillos = palillos; 
		palilloDerecho = palillos[num_filosofo];
		palilloIzquierdo = palillos[((num_filosofo+1)%5)];
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			if(palilloDerecho.get_disponible() && palilloIzquierdo.get_disponible()) //Si ambos palillos estan disponibles el filosofo come
			{                                                                        //Caso contrario, piensa
				synchronized(this)
				{
					palilloDerecho.tomar();
					palilloIzquierdo.tomar();
				}
			
				try 
				{
					Thread.sleep(2000); //Tiempo que tarda en comer
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			
				synchronized(this)
				{
					palilloDerecho.dejar();
					palilloIzquierdo.dejar();
					System.out.println("El Filosofo: " + Thread.currentThread().getName() + " comio");
				}
			}
		
			else //No puede comer, por lo tanto piensa
			{
				try 
				{
					System.out.println("El Filosofo: " + Thread.currentThread().getName() + " esta pensando");
					Thread.sleep(2000); //Tiempo que tarda en pensar
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
