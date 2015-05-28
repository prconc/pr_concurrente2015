
public class Consumidor implements Runnable{
	int elem;
	Buffer buffer;
	
	Consumidor(Buffer b, int i){
		buffer = b;
		System.out.println("Entra el consumidor " + i);
	}
	
	public void run(){
		try {
			elem = buffer.extraer();
		} catch (Exception e){}
		System.out.println("Se ha consumido " + elem);
		return;
	}

}
