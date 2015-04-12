public class Buffer {
	int tamano = 10;
	int[] valores;
	int lastPos = 0;
	int cima = 0;

	Buffer() {
		tamano = 10;
		valores = new int[tamano];
	}

	synchronized public void producir(int valor) {
		valores[lastPos] = valor;
		System.out.println("Produciendo el valor " + valor + " en la posición "
				+ lastPos + " del Buffer.");
		lastPos++;
		cima++;
		lastPos = lastPos % tamano;
		if (cima > tamano)
			cima = tamano;
		notifyAll();
	}

	synchronized public void consumir() {
		while (cima <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cima--;
		lastPos--;
		if (lastPos == -1) {
			lastPos = (tamano - 1);
		}
		System.out.println("Consumiendo el valor " + valores[lastPos]
				+ " en la posición " + lastPos + " del Buffer.");
	}
}