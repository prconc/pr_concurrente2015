public class Main {

	public static void main(String[] args) {

		Buffer buffer = new Buffer();
		Consumidor consumidor = new Consumidor(buffer);
		Productor productor = new Productor(buffer);

		for (int i = 0; i < 30; i++) {
			Thread hilo_productor = new Thread(productor);
			hilo_productor.start();
		}

		for (int i = 0; i < 10; i++) {
			Thread hilo_consumidor = new Thread(consumidor);
			hilo_consumidor.start();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Fin del hilo main");
	}

}
