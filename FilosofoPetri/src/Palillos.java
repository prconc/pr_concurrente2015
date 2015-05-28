public class Palillos {
	private SemaforoBinario mutex;
	private SemaforoBinario miCondicion;
	int bloqueados;

	public Palillos(SemaforoBinario mutex) {
		this.mutex = mutex;
		miCondicion = new SemaforoBinario(0);
		bloqueados = 0;
	}

	public void DELAY() {
		bloqueados++;
		mutex.SIGNAL();
		miCondicion.WAIT();
		mutex.WAIT();
	}

	public void RESUMEN() {
		if (bloqueados > 0) {
			bloqueados--;
			miCondicion.SIGNAL();
		}
	}

	public boolean EMPTY() {
		if (bloqueados > 0)
			return false;
		return true;
	}
}
