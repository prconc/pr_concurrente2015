public class Consumidor implements Runnable{
	
	private variable val;
	private Semaforo c1;
	private Semaforo c2;
	private Semaforo mutex;
	private int id;
	
	public Consumidor (variable b, Semaforo s1, Semaforo s2, Semaforo mute,int a){
	
		val = b;
		c1=s1;
		c2=s2;
		mutex=mute;
		id=a;
		
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			
			
			try {
				//System.out.println("Buffer =" + val.getval() );	
				//System.out.println("wait c1("+c1.get_valor() +")" );	
				c1.WAIT();
				mutex.WAIT();
				val.decre();
				Thread.sleep(500);
				System.out.println("Decrementando " + id +  ",buffer = " + val.getval() );	
				mutex.SIGNAL();
				c2.SIGNAL();
				
				
				
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//System.out.println( " escribiendo "+  val.getval() );
			
			
		
				
		}
	}
}
