
public class Semaforo 

{
int contador;

public void semaforo(int valor)
{
	
    contador=valor;
}
	
synchronized void WAIT()
{
	while(contador==0)
	{
		try
		{
		wait();
		}
		catch(Exception e){}
	}
	
	contador --;
	
	
}

synchronized void SIGNAL()
{
	contador ++;
	notify();
}
	
}
