public class Lector implements Runnable{
	Recurso recurso;
	 
	public Lector(Recurso recurso){
		 this.recurso = recurso;	 
	 }

	public void run() {	
		recurso.leer();
		
	}
	
}