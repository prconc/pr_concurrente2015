
public class Consumidor implements Runnable {
	Buffer buffer;
		
	Consumidor(Buffer b){
		this.buffer=b;
	}

		public void run(){
		try{
			buffer.extraer();
		} catch (Exception e) {}
		System.out.println("Consumidor ha sacado un elemento");
		return;
	}
}