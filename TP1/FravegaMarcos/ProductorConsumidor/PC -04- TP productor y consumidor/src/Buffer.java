
public class Buffer {
	
	private int[] bufferCir;
	private int punteroProductor;
	private int punteroConsumidor;
	
	public Buffer() {
		
		bufferCir = new int[5];
		for(int i = 0; i<5; i++) {
			bufferCir[i] = 0;
		}
		punteroProductor = 0;
		punteroConsumidor = 0;
	}
	
	synchronized public void producir() {
		
		while (bufferCir[punteroProductor] == 1) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		bufferCir[punteroProductor] = 1;
		punteroProductor = (punteroProductor + 1) % 5;
		
		System.out.println("Se produjo un elemento");
		System.out.println(bufferCir[0]+" "+bufferCir[1]+" "+bufferCir[2]+" "+bufferCir[3]+" "+bufferCir[4]);
		System.out.println("------------------------------");
		notify();
	}
	
	synchronized public void consumir() {
		
		while (bufferCir[punteroConsumidor] == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		bufferCir[punteroConsumidor] = 0;
		punteroConsumidor = (punteroConsumidor + 1) % 5;
		
		System.out.println("Se consumio un elemento");
		System.out.println(bufferCir[0]+" "+bufferCir[1]+" "+bufferCir[2]+" "+bufferCir[3]+" "+bufferCir[4]);
		System.out.println("------------------------------");
		notify();
	}
}
