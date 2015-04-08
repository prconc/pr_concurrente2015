

public class Consumidor implements Runnable {

  int id;
   Buffer buf ;
   int elem ;
   
	
	public  Consumidor (int i, Buffer b  ){
		
		this.id=i;
		buf=b;	
	}
	
	
	@Override
	public void run() {
		
	
		while (true){
		
		try {
			Thread.sleep(200);
		
			buf.decrementar(id);
		
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
		}
		
	}

}
