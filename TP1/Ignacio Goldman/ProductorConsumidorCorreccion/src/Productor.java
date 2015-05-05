public class Productor implements Runnable {
	int elem;
	Buffer b;
	
	public Productor(int elem, Buffer b){
		this.b = b;
		this.elem = elem;
	}
	
	public void run(){
		try{b.agregar(elem);}
		catch(Exception e){e.printStackTrace();}
	}
}
