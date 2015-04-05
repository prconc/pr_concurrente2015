
public class Main 
{

	public static void main(String[] args) 
	{
		Buffer buffer = new Buffer();

		for(int i=0; i<4; i++)								//Se crean 4 productores y 4 consumidores.
		{
			Productor productor = new Productor(buffer);
			Thread t1 = new Thread(productor);
			t1.setName("P" + (i+1));						//Se identifican los productores como P1,P2,P3,P4.
			
			Consumidor consumidor = new Consumidor(buffer);
			Thread t2 = new Thread(consumidor);
			t2.setName("C" + (i+1));						//Se identifican los consumidores como C1,C2,C3,C4.
			
			t1.start();
			t2.start();
		}
	}
}
