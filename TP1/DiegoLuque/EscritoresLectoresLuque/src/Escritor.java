
public class Escritor extends Thread {
	int miId;
	Recurso recurso;
	
	public Escritor (Recurso _recurso, int _miId) {
		miId= _miId;
		recurso= _recurso; 
	}
	
	public void run (){
		int i=0;
		while (i<10){
			System.out.println("Escritor "+miId+" quiere escribir");
			recurso.escribir();
			System.out.println("Escritor "+miId+" ha terminado");
			i++;
		}
	}
}
