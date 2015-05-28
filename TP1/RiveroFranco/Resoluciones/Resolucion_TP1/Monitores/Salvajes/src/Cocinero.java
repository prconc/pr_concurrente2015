
public class Cocinero extends Thread{

	Olla olla;

	public void setOlla(Olla olla) {
		this.olla = olla;
	}

	public void run(){
		for(int i= 0; i< 30; i++){
			try {
				Thread.sleep(50);
				olla.cocinar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
