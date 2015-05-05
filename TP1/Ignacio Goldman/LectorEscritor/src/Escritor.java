public class Escritor implements Runnable{
	Recurso recurso;
	 
	public Escritor(Recurso recurso){
		 this.recurso = recurso;	 
	 }

	public void run() {
		for(int i=0;i<10;i++){
		recurso.escribir();
		}
	}
	
}
