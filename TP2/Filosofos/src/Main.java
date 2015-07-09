public class Main 
{
	public static void main(String[] args) 
	{
		Monitor monitor = new Monitor();
		
		for(int i=0; i<10; i=i+2)
		{
			Filosofo filosofo = new Filosofo(i, monitor);
			Thread t = new Thread(filosofo);
			
			t.start();
		}		
	}
}
