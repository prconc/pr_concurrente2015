
public class Lector implements Runnable{
	
	Recurso recurso;
	String id;
	
	public Lector(Recurso r, String id){
		
		recurso = r;
		this.id = id;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			
			
			recurso.leer(id);
			try {
				Thread.sleep((int)(100+Math.random()*(1000)));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
