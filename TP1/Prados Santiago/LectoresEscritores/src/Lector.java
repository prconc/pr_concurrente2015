



public class Lector implements Runnable  {

	int id ;
	Buffer buf;
	

	public Lector (int i,Buffer b){
		buf=b;
        id=i;	
		}
	
	
	@Override
	public void run() {
		
    while (true) {
			
			
			try {
				Thread.sleep (100);
				
					buf.leerDato(id);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  
		
			
		}		
		
		
		
		
	}

	
	
	
	
	
	
}
