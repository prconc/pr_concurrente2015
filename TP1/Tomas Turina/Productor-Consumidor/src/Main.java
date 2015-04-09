import java.util.Random;

public class Main 
{

	public static void main(String[] args) 
	{
		Buffer buffer = new Buffer(5);
		
		for(int i=0;i<4;i++)
		{
			Random numero = new Random(); //Valor aleatorio para identificar el producto
			int num = numero.nextInt(99);
			
			Productor p = new Productor(buffer, num);
			Consumidor c = new Consumidor(buffer);
			
			Thread hilo1 = new Thread(p);
			Thread hilo2 = new Thread(c);
			hilo1.setName("Productor "+ i + ": " + num);
			hilo2.setName("Consumidor "+ i);
			
			hilo1.start();
			hilo2.start();
		}
	}
}
