
public class Lector extends Thread {
	int miId;
	Recurso recurso;
	
	public Lector(Recurso _recurso, int _miId) {
		miId = _miId;
		recurso= _recurso;
	}
	
	public void run () {
		int i=0;
		while (i<10) {
			System.out.println("Lector "+miId+" quiere leer");
			recurso.leer();
			System.out.println("Lector "+miId+" ha terminado");
			i++;
		}
	}
}
