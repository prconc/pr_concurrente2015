
public class Palillo {

	boolean libre;
	
	Palillo(){
		libre=true;
	}
	
	synchronized public void agarrar (int quien){
		while (!libre){//el filosofo agarro este palillo
			try{wait();}
			catch (Exception e){}
			
		}
		libre=false;
	}
	
	synchronized public void soltar(){
		libre=true;
		notifyAll();
	}
}
