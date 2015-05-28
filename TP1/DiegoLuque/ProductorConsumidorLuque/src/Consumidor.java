
public class Consumidor extends Thread {
	int elem;
	Buffer buffer;
	Consumidor (Buffer b, int i) {
		buffer=b;
	}
	
	public void run() {
		try {
			elem=buffer.extraer();
		} catch (Exception e){}
		System.out.println ("he extraido el elemento "+elem);
		return;
	}
}
