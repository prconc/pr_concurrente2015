public class Lector implements Runnable{
	
	Recurso recurso;
	String id;
	
	public Lector(Recurso r, String id){
		
		recurso = r;
		this.id = id;
		
	}

	public void run() {
		while(true){
			recurso.leer(id);
			try {
				Thread.sleep((int)(100+Math.random()*(1000)));
			} catch (InterruptedException e) {}
			
		}
	}

}