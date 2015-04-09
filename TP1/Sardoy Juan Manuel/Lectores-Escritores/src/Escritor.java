
public class Escritor implements Runnable {
	
	Recurso recurso;
	String id;
	
	public Escritor(Recurso r, String id){
		
		recurso = r;
		this.id = id;
		
	}

	@Override
	
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			int a =(int)(Math.random()*(11));
			
			recurso.escribir(id, a);
			
			try {
				Thread.sleep((int)(1000+Math.random()*(1000)));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	

}
