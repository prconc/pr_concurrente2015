
public class Productor implements Runnable{
	Buffer buffer;
	int elem;
	
	Productor (Buffer b, int i){
		elem = i;
		buffer = b;
		System.out.println("Entra el productor " + i);
	}

	public void run(){
		try {
			buffer.insertar(elem);
		} catch (Exception e){}
		System.out.println("Se ha producido " + elem);
		return;
	}
}
