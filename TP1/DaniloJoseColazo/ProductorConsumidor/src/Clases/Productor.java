package Clases;

public class Productor extends Thread{
	Buffer buffer;
	int elem;
	
	Productor (Buffer b, int i) {
		elem = i;
		buffer = b;
		System.out.println("Entra el productor "+ i);
	}
	
	public void run () {
		try {
			buffer.insertar(elem);
		} catch(Exception e) {}
		System.out.println("He puesto el elemento "+ elem);
		return;
	}
}
