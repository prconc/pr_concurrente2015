public class main 
{
	public static void main(String[] args) 
	{
		Filosofos[] filosofo = new Filosofos[5];
		Palitos[] palitos = new Palitos[5];
	
	
		for(int i=0; i<5; i++)
		{
			palitos[i] = new Palitos();	//Inicializacion de palitos
			
			if(i!=4)					//Inicializacion de filosofos
			{
				filosofo[i] = new Filosofos(i, palitos[i], palitos[i+1]);
			}
			else
			{
				filosofo[i] = new Filosofos(i, palitos[i], palitos[0]);
			}
			
			Thread hilo = new Thread(filosofo[i]); 
			
			if(i == 0 || i == 2)
			{
				hilo.start();
			}
			else
			{
				try 
				{
					Thread.sleep(100);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			if(i == 1 || i == 3)
			{
				hilo.start();
			}
			else
			{
				try 
				{
					Thread.sleep(100);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			hilo.start();
		}
	}
}
