
public class Palillo {
	
	boolean libre;
	Palillo() {
		libre = true;
	}
	
	synchronized public void tomar (int quien) {
		while(!libre){
			try {
				wait();
			}
			catch (Exception e) { }
			} 
		libre = false;
	}

	synchronized public void soltar (){
		libre = true;
		notifyAll();
	}
}
