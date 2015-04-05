public class Main 
{

	public static void main(String[] args) 
	{
		Buffer buffer = new Buffer();


		for(int i=0; i<5; i++)
		{
			Lector lector = new Lector(buffer);
			Escritor escritor = new Escritor(buffer);
			
			Thread t1 = new Thread(lector);
			t1.setName("L" + (i+1));
			Thread t2 = new Thread(escritor);
			t2.setName("E" + (i+1));
			
			t1.start();
			t2.start();
		}
	}

}

