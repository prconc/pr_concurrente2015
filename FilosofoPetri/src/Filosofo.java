public class Filosofo implements Runnable {

	private String id;
	private int nroEjecuciones;
	private int comer, dejarDeComer;
	private Monitor miMonitor;

	public Filosofo(String nombre, int comer, int dejarDeComer,
			Monitor miMonitor, int nroEjecuciones) {
		id = nombre;
		this.comer = comer;
		this.dejarDeComer = dejarDeComer;
		this.miMonitor = miMonitor;
		this.nroEjecuciones = nroEjecuciones;
	}

	public void run() {
		for (int i = 0; i < nroEjecuciones; i++) {
			System.out.println("El " + id + " esta pensando...");
			miMonitor.comer(comer);
			System.out.println("El " + id + " esta comiendo. Transicion: "
					+ comer);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			miMonitor.devolverPalillos(dejarDeComer);
			System.out.println("El " + id + " dejo de comer. Transicion: "
					+ dejarDeComer);
		}

	}

}
