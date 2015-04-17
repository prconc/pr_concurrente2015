
public class Consumidor implements Runnable{
	
	Semaforo consu,produ;
	Buffer compartido;
	
	public Consumidor(Semaforo c,Semaforo s,Buffer a){
		consu=c;
		produ=s;
		compartido=a;
		
		
	}
	
	public void run(){
		while(true){
			
		consu.WAIT();
		compartido.Consumir();
		produ.SIGNAL();
		
		}
		
	}
	
}
