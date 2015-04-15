
public class Lector implements Runnable{

	private Semaforo wrt;
	private Semaforo mutex;
	private int id;
	private int nl;
	boolean wait;
	
	public Lector (Semaforo s1, Semaforo mute,int a){
	
		wrt=s1;
		mutex=mute;
		id=a;
		nl=0;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			
			
			try {
			
				
				mutex.WAIT();
				nl=nl+1;
				//System.out.println("Nl vale :"+ nl);
				//System.out.println("wait vale :"+ wait );
				if(nl==1 && wrt.getBool()==false )
						{
			//	System.out.println("Entra al if, para dormir wrt");
					wrt.WAIT();
				//System.out.println("Pasa if del wait, wrt");
					//wrt.changeBoolT();
					
						}
				else{
					
				    }
				mutex.SIGNAL();                                                                                                             
				
				System.out.println("Lector " + id +  " Leyedo");	
				Thread.sleep(2000);
				
				mutex.WAIT();
				//System.out.println("Pasa WAIT 1");
				nl=nl-1;
				if(nl==0)
						{
				//	System.out.println("Entra al if, para despertar wrt");
					wrt.SIGNAL();
					//wrt.changeBoolF();
						}
				else{
					
				    }
				//System.out.println("Despierta mutex");
	            mutex.SIGNAL();
	         
				
				
				
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block                                        
				e1.printStackTrace();
			}
			
			
		
				
		}
	}

	
}
