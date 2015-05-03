public class Escritor implements Runnable{
	Recurso recurso;
	 
	public Escritor(Recurso recurso){
		 this.recurso = recurso;	 
	 }

	public void run() {
		recurso.escribir();
	}
	
}