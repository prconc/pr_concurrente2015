public class Productor implements Runnable {

	Buffer buffer;
	int elem;
	
	Productor (Buffer b,int i){
		elem=i;
		buffer=b;
		System.out.println("entra el productor "+i);
	}
	
	public void run(){
		while(true){
		try{
			buffer.insertar(elem);
		}catch (Exception e){}
		System.out.println("he puesto el elemento "+elem);
		return;
	}
 }
}
