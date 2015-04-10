
public class Lector extends Thread {
	int miID;
	Recurso recurso;
	
	public Lector(Recurso recurso, int miID) {
		this.miID = miID;
		this.recurso = recurso;
	}
	
	public void run() {
		int i = 0;
		while(i<10) {
			System.out.println("Lector " + miID + " quiere leer");
			recurso.leer();
			System.out.println("Lector "+ miID + " ha terminado");
		}
	}
}
