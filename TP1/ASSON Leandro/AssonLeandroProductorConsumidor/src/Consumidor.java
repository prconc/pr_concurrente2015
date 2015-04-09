import java.util.Random;

public class Consumidor implements Runnable

{
private buffer Buffer;
private Random random;

public Consumidor (buffer Buffer)
{
 this.Buffer = Buffer;
 random=new Random();
 Thread.currentThread().setPriority(1);
}

public void run()
{
		int tiempo_entre_consumo = random.nextInt(1000);//tiempo de hasta de un segundo entre operacion y operacion.

		for(int i=0; i<10; i++)
		{
			Buffer.quitar();
		try
		{
			Thread.sleep(tiempo_entre_consumo);
		}
		catch(InterruptedException c)	
			{
			c.printStackTrace();
			}
			
		}
				
}


}

