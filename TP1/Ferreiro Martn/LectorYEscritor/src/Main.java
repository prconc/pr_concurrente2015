
public class Main {

	public static void main(String args[])
	{
		Recurso recurso = new Recurso();
		
		for (int i = 0; i< 3 ; i++){
		
		Lector lector = new Lector (recurso, i);
		Thread t= new Thread (lector);
		t.start ();
		
		
		Escritor escritor= new Escritor (recurso, i);
		Thread y= new Thread (escritor);
		y. start ();
		}
	}
}