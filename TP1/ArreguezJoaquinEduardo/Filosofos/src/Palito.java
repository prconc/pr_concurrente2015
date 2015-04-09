
public class Palito {
	boolean libre;
	int posicion;

	public Palito(int posicion) {
		this.posicion=posicion;
		libre=true;
	}
	
	
	synchronized public void agarrar(){
		
		while(!libre){
			try {wait();}
			catch (Exception e){ e.printStackTrace();}	
			}
		
		libre=false;
		notifyAll();
		}
	
	
	synchronized public void soltar(){
		
		libre=true;
		notifyAll();
		}

}
