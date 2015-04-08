

public class Buffer {

	private int cima,capacidad,vector[];
	
	public Buffer (int i ){
	
		cima =0;
		capacidad=i;
		vector = new int [i]; 
		
	}
	
	
	public synchronized void  incrementar (int id ,int dato){
		
		
		while (cima==capacidad-1)
			try {
				wait();
		
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		
		
	
	
		vector [cima]=dato;
		
		System.out.println ("Productor ID " + id + " Dato  = " + dato + " Lugar del bufer = "+cima);
		
		cima++;
		
		notifyAll();
		
	
		
	}
	
	
	 public synchronized void decrementar (int id){
		
		while (cima == 0)
			try {
				wait();
		
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		--cima;
		System.out.println ("Consumidor ID "+id + " Dato  = " +vector [cima]+ " Lugar del bufer = "+cima);
		
		notifyAll();
				
	}
	
	
}
