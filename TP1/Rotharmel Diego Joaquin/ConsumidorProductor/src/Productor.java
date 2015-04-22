import java.util.Random;

public class Productor implements Runnable{
	Random randomGenerator = new Random();
	Buffer __buffer__;
	int __elemento__ = randomGenerator.nextInt(100);
	
	public Productor(Buffer b){		
		__buffer__ = b;
	}
	
	public void run(){
		try{
			__buffer__.insertar(__elemento__);
		} catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Productor ha colocado el elemento "+__elemento__);
	}
}
