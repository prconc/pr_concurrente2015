

public class Main {

	public static void main(String[] args) 
	
	{
	Recurso recurso =new Recurso(10);	
	
	for(int i=0; i<3; i++)
	{
		Escritor e= new Escritor(recurso, i);
		Thread t2 = new Thread(e);
		t2.start();
		
	}

	for(int i=0; i<3; i++)
	{
		Lector l= new Lector(recurso, i);
		Thread t1 = new Thread(l);
		t1.start();
	}
	
	}

}
