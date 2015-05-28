
import java.util.concurrent.TimeUnit;
public class Filosofo extends Thread {
	MonitorInterface monitor;
	int [] disparoCom;
	int [] disparoTerm;
	int filNum;
	
	public Filosofo(MonitorInterface monitor,int disparoCom[],int disparoTerm[],int filNum) {
		super();
		this.monitor = monitor;
		this.disparoCom = disparoCom;
		this.disparoTerm = disparoTerm;
		this.filNum = filNum;
	}

	public void run() {
		System.out.println("Se ejecuto Filosofo"+ filNum);
		
		for(int i= 1; i<= 5; i++){
			
			try {
				System.out.println("Filosofo " + filNum + " INTENTA COMER");
				monitor.comer(disparoCom);
				
				//System.out.println("El filosofo "+ filNum + " comio "+i+"veces");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Filosofo " + filNum + " Esta Comiendo.");
			
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			try {
				monitor.terminar(disparoTerm);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("Filosofo " + filNum + " TERMINO DE COMER");
		}
	}
}