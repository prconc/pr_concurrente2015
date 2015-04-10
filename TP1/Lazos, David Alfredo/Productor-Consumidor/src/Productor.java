
public class Productor implements Runnable{
	Buffer buffer;
	int elemento;
	
	Productor(Buffer b){
		this.buffer=b;
		}
	
	public void run(){
		try{
			buffer.insertar(elemento);
		} catch (Exception e) {}
		System.out.println("Productor ha colocado un elemento");
		return;
	}
}