package ClasesSemaforo;

public class Semaforo
{
	int senial;
	int bloqueado;
	
	public Semaforo(int senial)
	{
		this.senial = senial;
		bloqueado = 0;
	}
	
	synchronized public void espera()
	{
		while(senial<=0)
		{
			try 
			{
				bloqueado++;
				wait();
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
				// TODO: handle exception
			}
			
		}
		senial--;
		bloqueado--;
	}
	
	synchronized public void senial()
	{
		if(bloqueado == 0)
		{
			senial++;
		}
		
		notify();
	}
}
