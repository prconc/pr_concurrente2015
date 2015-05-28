public class Monitor {
	private ProcesadorPetri petri;
	private SemaforoBinario mutex = new SemaforoBinario(1);
	private Palillos cond = new Palillos(mutex);
	private static int[][] disparos = { { 0 }, { 0 }, { 0 }, { 0 }, { 0 },
			{ 0 }, { 0 }, { 0 }, { 0 }, { 0 } };
	Matrix disparo = new Matrix(disparos);

	public Monitor(Matrix incidencia, Matrix marcado) {
		this.petri = new ProcesadorPetri(incidencia, marcado, disparo);
	}

	public void comer(int disparar) {
		mutex.WAIT();
		// probar disparar la red
		while (!petri.disparoPosible(disparar)) {
			cond.DELAY();
		}
		petri.ejecutar(disparar);
		mutex.SIGNAL();
	}

	public void devolverPalillos(int disparar) {
		mutex.WAIT();
		petri.ejecutar(disparar);
		cond.RESUMEN();
		mutex.SIGNAL();

	}

}
