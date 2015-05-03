public class Lector implements Runnable{
	Recurso recurso;
	 
	public Lector(Recurso recurso){
		 this.recurso = recurso;	 
	 }

	public void run() {
		for(int i=0;i<10;i++){	
		recurso.leer();
		}
	}
	
}

