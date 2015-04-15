public class Palillos {
	private int val[];
	
	public  Palillos(int pal[]){
			  val = pal;
	}

	public synchronized void Wait(int i){
		if(i == 1){
			  
			while(val[4] == 0 || val[i-1] == 0 ){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			val[4] = 0;
			val[i-1] = 0;	
			
		}
		else  {
		while(val[i-2] == 0 || val[i-1] == 0 ){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		val[i-2] = 0;
		val[i-1] = 0; 
		
		
	}
	}
	public synchronized void Signal(int i){
		if(i == 1){
			val[4] = 1;
			val[i-1] = 1;
		}
		else{
			val[i-2] = 1;
			val[i-1] = 1; 
		}
			
		
		notifyAll();
	}
	
}
