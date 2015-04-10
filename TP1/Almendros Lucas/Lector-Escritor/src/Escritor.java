
public class Escritor extends Thread {
	int miID;
	Recurso recurso;
	
	public Escritor(Recurso recurso, int miID) {
		this.miID = miID;
		this.recurso = recurso;
	}
	
	public void run() {
		int i = 0;
		while(i<10) {
			System.out.println("Escritor " + miID + " quiere escribir");
			recurso.escribir();
			System.out.println("Escritor "+ miID + " ah terminado");
		}
	}

}
