
public class Salvaje extends Thread{

	MonitorInterface olla;

	public Salvaje(MonitorInterface olla) {
		super();
		this.olla = olla;
	}	

	public void run(){
		for(int i= 1; i<= 5; i++){
			try {
				olla.comer();
				System.out.println("El salvaje "+this.getName() + " comio "+i+"veces");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
