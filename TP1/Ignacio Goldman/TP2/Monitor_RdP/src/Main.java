public class Main {

	public static void main(String[] args) {
		
		Monitor monitor = new Monitor();
		Filosofos[] f= new Filosofos[5];
		
		
		for(int i=0; i<5; i++)//Inicializo filosofos
		{
			f[i] = new Filosofos(i,monitor);
		}
				
		for(int i=0; i<5;i++)//Creo threads
		{
			Thread t= new Thread(f[i]);
			t.start();
		}

	}	
}
