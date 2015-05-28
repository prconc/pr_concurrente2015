
public class Escritor implements Runnable {
	int id;
	Recurso recurso;
	
	public Escritor(Recurso _recurso, int _id){
		recurso = _recurso;
		id = _id;		
	}
	
	public void run(){
		int i=0;
		while (i<10){
			System.out.println("Escritor "+ id + " quiere escribir");
			recurso.escribir(i);
			System.out.println("Escritor "+ id + " ha terminado");
			i++;
		}
	}

}
