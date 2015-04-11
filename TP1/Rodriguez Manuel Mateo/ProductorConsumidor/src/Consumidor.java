public class Consumidor implements Runnable {

	int elem;
	Buffer buffer;
	Consumidor(Buffer b,int i){
		buffer=b;
	}
	public void run(){
		while(true){
		try{
			elem=buffer.extraer();
		}catch(Exception e){}
		return;
	}
 }	
}
