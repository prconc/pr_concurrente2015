
public class Lector implements Runnable {
	private int id;
	private Semaforo sesc;
	private Semaforo slec;
	private int n1;
	Lector(int a,Semaforo b,Semaforo c){
		id=a;
		sesc=b;
		slec=c;
		n1=0;
	}
	public void run(){
		
		while(true){
			try {
			slec.WAIT();
			n1=n1+1;
			if(n1==1 && sesc.get_stop()==false ){sesc.WAIT();}
			slec.SIGNAL();
			System.out.println("Lector[" + id +  "] Leyendo");
			Thread.sleep(500);
			slec.WAIT();
			n1=n1-1;
			if(n1==0){sesc.SIGNAL();}
			slec.SIGNAL();
			} 
			catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}
