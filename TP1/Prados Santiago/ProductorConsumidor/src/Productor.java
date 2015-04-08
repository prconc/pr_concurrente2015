

import java.util.Random;


public class Productor implements Runnable {

int id ;
	
	Buffer buf ;
	
	
	public  Productor (int i ,Buffer b){
		
		this.id=i;
		
		buf=b;
		
		
	}
	
	@Override
	public void run() {
		
		while (true){
		 
			Integer dato = new Integer(new Random().nextInt(32));//genero datos aliatorios para insertar
			
			
			try {
				Thread.sleep(100);
				
				buf.incrementar(id,dato);
			
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			
		}
			
			
			
			
			
			
		
	
	}

}
