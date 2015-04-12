public class VectorConcurrente {
	boolean escribiendo;
	int numLectores;
	int vector[];
	int size;

	VectorConcurrente(int size) {
		escribiendo = false;
		numLectores = 0;
		vector = new int[size];
		this.size = size;
	}

	public void escribir(int valor, int indice) {
		synchronized (this) {
			while (escribiendo || (numLectores > 0)) {
				try {
					wait();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
			escribiendo = true;
		}

		if (size > indice)
			vector[indice] = valor;

		synchronized (this) {
			escribiendo = false;
			notifyAll();
		}

	}

	public int leer(int indice) {
		synchronized (this) {
			while (escribiendo) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				numLectores++;
			}
		}
		int resultado = vector[indice];

		synchronized (this) {
			numLectores--;
			if (numLectores == 0)
				notifyAll();
		}
		return resultado;
	}

}
