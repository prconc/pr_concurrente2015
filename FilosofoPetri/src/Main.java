public class Main {

	private static int nroFilosofos = 5;
	private static int nroEjecuciones = 3;
	private static int[][] marcadoInicial = { { 1 }, { 1 }, { 0 }, { 1 },
			{ 1 }, { 0 }, { 1 }, { 1 }, { 0 }, { 1 }, { 1 }, { 0 }, { 1 },
			{ 1 }, { 0 } };// p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14

	// t0,t1,t2,t3,t4,t5,t6,t7,t8,t9
	private static int[][] Incidencia = { { -1, 1, 0, 0, 0, 0, 0, 0, -1, 1 },// p0
			{ -1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },// p1
			{ 1, -1, 0, 0, 0, 0, 0, 0, 0, 0 },// p2
			{ -1, 1, -1, 1, 0, 0, 0, 0, 0, 0 },// p3
			{ 0, 0, -1, 1, 0, 0, 0, 0, 0, 0 },// p4
			{ 0, 0, 1, -1, 0, 0, 0, 0, 0, 0 },// p5
			{ 0, 0, -1, 1, -1, 1, 0, 0, 0, 0 },// p6
			{ 0, 0, 0, 0, -1, 1, 0, 0, 0, 0 },// p7
			{ 0, 0, 0, 0, 1, -1, 0, 0, 0, 0 },// p8
			{ 0, 0, 0, 0, -1, 1, -1, 1, 0, 0 },// p9
			{ 0, 0, 0, 0, 0, 0, -1, 1, 0, 0 },// p10
			{ 0, 0, 0, 0, 0, 0, 1, -1, 0, 0 },// p11
			{ 0, 0, 0, 0, 0, 0, -1, 1, -1, 1 },// p12
			{ 0, 0, 0, 0, 0, 0, 0, 0, -1, 1 },// p13
			{ 0, 0, 0, 0, 0, 0, 0, 0, 1, -1 } };// p14

	public static void main(String[] args) {

		Matrix incidencia = new Matrix(Incidencia);
		Matrix marcado = new Matrix(marcadoInicial);

		Monitor miMonitor = new Monitor(incidencia, marcado);

		for (int i = 0; i < nroFilosofos; i++) {
			Filosofo f = new Filosofo("Filosofo " + (i + 1), i * 2,
					(i * 2) + 1, miMonitor, nroEjecuciones);
			Thread t = new Thread(f);
			t.start();
		}

	}

}
