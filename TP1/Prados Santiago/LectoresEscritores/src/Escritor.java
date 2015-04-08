

import java.util.Random;

public class Escritor implements Runnable {

	int id;
	Buffer buf;
	

	public Escritor (int i,Buffer b){
		buf=b;
        id=i;	
		}
	
	
	@Override
	public void run() {
		
		
		  while (true) {
				
				
				try {
					Thread.sleep (100);
					
					// Genero datos aliatorios para insertar en el Buffer
					Integer dato = new Integer(new Random().nextInt(32));
					
					// Inserto Datos
					
					buf.escribirDato(id,dato);
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			  
			  
			
				
			}	
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
