public class Main {

	public static void main(String[] args) {

		Monitor monitor = new Monitor();
		Filosofos[] f= new Filosofos[5];


		for(int i=0; i<5; i++)
		{
			f[i] = new Filosofos(i,monitor); //Creo el filosofo 
			Thread t= new Thread(f[i]);		 //Creo el hilo
			t.start();

		}
	}	
}
