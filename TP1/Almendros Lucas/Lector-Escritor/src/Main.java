
public class Main {

	public static void main(String[] args) {
		Recurso recurso = new Recurso();
		
		for(int i = 0; i < 5 ; i++)
			new Lector(recurso, i).start();
		
		for(int i = 0; i < 2 ; i++)
			new Escritor(recurso, i).start();
	}

}
