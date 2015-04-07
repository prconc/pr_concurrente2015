
public class Main {

	public static void main(String[] args) {
		
		Buffer buffer = new Buffer();
		
		Escritor escritor1 = new Escritor(buffer, 1);
		Escritor escritor2 = new Escritor(buffer, 2);
		Lector lector1 = new Lector(buffer, 1);
		Lector lector2 = new Lector(buffer, 2);
		Lector lector3 = new Lector(buffer, 3);
		
		Thread hiloEscritor1 = new Thread(escritor1);
		Thread hiloEscritor2 = new Thread(escritor2);
		Thread hiloLector1 = new Thread(lector1);
		Thread hiloLector2 = new Thread(lector2);
		Thread hiloLector3 = new Thread(lector3);
		
		hiloEscritor1.start();
		hiloEscritor2.start();
		hiloLector1.start();
		hiloLector2.start();
		hiloLector3.start();
	}
}
