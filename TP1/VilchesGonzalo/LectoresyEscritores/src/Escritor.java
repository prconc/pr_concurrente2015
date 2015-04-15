public class Escritor implements Runnable{
	
	private Semaforo wrt;
	private int id;
	
	public Escritor ( Semaforo s1,int a){
	
		wrt=s1;
		id=a;
		
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			
			
			try {
				
				wrt.WAIT();
				System.out.println("Escritor " + id +  " Escribiendo");	
				Thread.sleep(2000);
				
				wrt.SIGNAL();
				
				
				
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		
				
		}
	}

}

