
public class Salvaje extends Thread{

	Monitor olla;

	public Salvaje(Monitor olla) {
		super();
		this.olla = olla;
	}	

	public void run(){
		for(int i= 1; i<= 5; i++){
			try {
				Thread.sleep(100);
				olla.comer();
				System.out.println("El salvaje "+this.getName() + " comio "+i+"veces");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
