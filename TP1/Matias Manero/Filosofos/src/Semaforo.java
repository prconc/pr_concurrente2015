
public class Semaforo {

	int numero;  
	boolean uso;
	   
	public Semaforo(int x){  
		
	 numero = x;
	 uso=true;
	 
	 }  
	  
	synchronized public void Wait(){   
	      while(!uso){  
	    	  
	         System.out.println("Tenedor "+numero+" esta en uso"); 
	         
	         try {
	        	  
	        	 	wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	      }
	      	
	         uso= false;  
	         System.out.println("Empezando a usar el tenedor "+numero);  
	      }  
	  
	  
	synchronized public void Signal(){   
	    
		
		uso = true;  
		notifyAll();
		System.out.println("Tenedor "+numero+" esta ahora disponible");  
	   }  
  

}

