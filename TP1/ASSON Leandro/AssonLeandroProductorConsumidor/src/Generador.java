import java.util.Random;

public class Generador implements Runnable
{
 private buffer buffer;
 private Random random;

public Generador(buffer buffer)
    {
	this.buffer = buffer;
	random= new Random ();
	Thread.currentThread().setPriority(10);
    }


public void run ()
  {
	for(int i=0; i<10; i++)
	{
		int valor_a_agrgar = random.nextInt(100);//genera un numero aleatorio de 0 100.
		int tiempo_entre_operacion = random.nextInt(1000);//Tiempo de 1 segundo entre operacion y operacion.
	
		buffer.agregar(valor_a_agrgar);
		
		
		
		try
		{
		Thread.sleep(tiempo_entre_operacion);
		}
		catch(InterruptedException c)
		{
		c.printStackTrace();		
		}
	}
  }



}