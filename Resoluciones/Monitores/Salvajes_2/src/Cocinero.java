
public class Cocinero extends Thread{

	MonitorInterface olla;

	public void setOlla(MonitorInterface olla) {
		this.olla = olla;
	}

	public void run(){
		for(int i= 0; i< 30; i++){
			try {
				Thread.sleep(50);
				olla.cocinar();
				System.out.println("c"+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
