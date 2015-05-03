public class Consumidor implements Runnable{
Buffer b;
	
	public Consumidor(Buffer b){
		this.b = b;
	}
	
	public void run(){
		try{b.quitar();}
		catch(Exception e){e.printStackTrace();}
	}
}
