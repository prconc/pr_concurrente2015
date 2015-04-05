
public class Main {

	public static void main(String[] args) 
	{
		Semaforo s = new Semaforo(true, 1); //Semaforo binario inicializado en uno
		Mesa m = new Mesa();
		
		for(int i=0; i<5; i++)
		{
			Filosofo filosofo = new Filosofo(i, s, m);
			Thread t = new Thread(filosofo);
			
			t.setName("" + i);
			t.start();
		}
			
	}

}
