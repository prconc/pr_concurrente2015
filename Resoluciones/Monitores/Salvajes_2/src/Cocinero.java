
public class Cocinero extends Thread{

	Monitor olla;

	public void setOlla(Monitor olla) {
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
