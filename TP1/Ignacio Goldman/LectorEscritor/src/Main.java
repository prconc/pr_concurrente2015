public class Main {

	public static void main(String[] args) {
		Recurso recurso = new Recurso();
		
		for( int i=0 ; i<10 ;i++ ){
		Lector lector = new Lector(recurso);
		Escritor escritor = new Escritor(recurso);
		
		Thread hilo1 = new Thread(lector);
		Thread hilo2 = new Thread(escritor);
		hilo1.setName("Lector "+i);
		hilo2.setName("Escritor "+i);
		
		hilo1.start();
		hilo2.start();
		}
		
		

	}

}
