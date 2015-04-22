public class Main {
	static Buffer b = new Buffer(3);
	
	public static void main(String[] args){
		for(int i = 0; i < 5; i++){
			Productor productor = new Productor(b);
			Thread prod_thread = new Thread(productor);
			prod_thread.start();
		}
		
		for(int i = 0; i < 5; i++){
			Consumidor consumidor = new Consumidor(b);
			Thread cons_thread = new Thread(consumidor);
			cons_thread.start();
		}
		System.out.println("Fin del hilo main");
	}
}
