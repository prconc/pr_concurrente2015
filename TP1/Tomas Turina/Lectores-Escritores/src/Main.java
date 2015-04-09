
public class Main 
{

	public static void main(String[] args) 
	{
		Recurso libro = new Recurso(); //Creamos un libro sobre el cual se leera y escribira
		for(int i=0;i<5;i++)
		{
			Escritor escritor = new Escritor(libro);
			Lector lector = new Lector(libro);
			
			Thread hilo1 = new Thread(escritor);
			Thread hilo2 = new Thread(lector);
			hilo1.setName("Escritor "+ i);
			hilo2.setName("Lector "+ i);
			
			hilo1.start();
			hilo2.start();
		}
	}

}
