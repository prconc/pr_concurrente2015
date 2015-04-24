
public class Lector implements Runnable {
	int id;
	Recurso recurso;
	
	public Lector(Recurso _recurso, int _id){
		id = _id;
		recurso = _recurso;
	}
	
	public void run(){
		int i=0;
		while (i<10){
			System.out.println("Lector "+ id + " quiere leer");
			recurso.leer();
			System.out.println("Lector "+ id + " ha terminado");
			i++;
		}
	}

}
