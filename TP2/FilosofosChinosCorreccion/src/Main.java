
public class Main {

	public static void main(String[] args) 
	{
		Monitor monitor = new Monitor();
		RedPetri red= new RedPetri();
		
		for(int i=0; i<10; i=i+2)
		{
			Filosofo filosofo = new Filosofo(i, monitor, red);
			Thread t = new Thread(filosofo);
			
			t.setName("" + i);
			t.start();
		}		
	}
}
