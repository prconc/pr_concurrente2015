
public class Productor implements Runnable{
	Semaforo c,s;
	Buffer compartido;
	
	
	public Productor(Semaforo con, Semaforo pro,Buffer a){
		c=con;
		s=pro;
		compartido=a;
		
		
	}
	

 public void run(){
	
	 while(true){
	 s.WAIT();
	 compartido.Producir();
	 c.SIGNAL();
	 
	 try {
		 Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	 }
 }
		
}
