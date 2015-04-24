public class SemaforoBinario {

	int contador;
	int bloqueo;

	SemaforoBinario(int v) {
		contador = v;
		bloqueo = 0;
	}

	synchronized public void WAIT() {
		while (contador <= 0) {
			try {
				bloqueo++;
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		contador--;
		bloqueo--;
	}

	synchronized public void SIGNAL() {
		if (bloqueo == 0)
			contador++;

		notify();
	}

}