public class Productor implements Runnable{
	
	private variable val;
	private Semaforo c1;
	private Semaforo c2;
	private Semaforo mutex;
	private int id;
	
	public Productor (variable b, Semaforo s1, Semaforo s2, Semaforo mute, int a){
	
		val = b;
		c1=s1;
		c2=s2;
		mutex=mute;
		id=a;
		
		
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			// System.out.println("valor anteoir "+  val.getval() );
		try {
			//System.out.println("Buffer =" + val.getval() );	
			//System.out.println("wait c2("+c2.get_valor() +")" );	
			c2.WAIT();
			mutex.WAIT();
			val.incre();
		   Thread.sleep(500);
			System.out.println("Incrementando " + id +  ",buffer = " + val.getval() );
			mutex.SIGNAL();
			c1.SIGNAL();
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
			   
			     
			//System.out.println( " escribiendo "+  val.getval() );
			
			

				
		}
	}
}