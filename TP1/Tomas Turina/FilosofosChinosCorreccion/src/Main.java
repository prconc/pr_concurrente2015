public class Main 
{
	public static void main(String[] args) 
	{
		Mesa mesa = new Mesa(); //Contiene los 5 palillos
		Semaforo semaforo = new Semaforo(true, 1);
		
		for(int num_fil=0; num_fil<5; num_fil++)
		{
			Filosofo filosofo = new Filosofo(num_fil, mesa, semaforo);
			Thread t = new Thread(filosofo);
			
			t.start();
			t.setName("" + (num_fil+1));
		}			
	}
}