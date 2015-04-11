public class Palito {

	boolean libre;
	
	Palito(){
		libre=true;
		}
	
	synchronized public void agarrar(){
		while(!libre){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		libre=false;
	}
    synchronized public void soltar(){
    	libre=true;
    	notifyAll();
    }
}
