
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Buffer buffer = new Buffer();
		Productor productor = new Productor(buffer);
		Consumidor consumidor = new Consumidor(buffer);
		
		Thread P = new Thread(productor);
		Thread C = new Thread(consumidor);
		
		P.start();
		C.start();
		


	}

}
