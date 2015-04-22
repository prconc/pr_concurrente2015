public class Consumidor implements Runnable{
	Buffer __buffer__;
	int __elemento__;
	
	public Consumidor(Buffer b){
		__buffer__ = b;
	}
	
	public void run(){
		try{
			__elemento__ = __buffer__.extraer();
		} catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Consumidor ha sacado el elemento "+__elemento__);
	}
	
}
