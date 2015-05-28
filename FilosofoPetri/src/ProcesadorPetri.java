public class ProcesadorPetri {

	private Matrix Incidencia;
	private Matrix marcado;
	private Matrix disparo;
	private Matrix auxiliar;

	public ProcesadorPetri(Matrix Incidencia, Matrix marcado, Matrix disparo) {
		this.Incidencia = Incidencia;
		this.marcado = marcado;
		this.disparo = disparo;
	}

	public void colocarUno(int numTransicion) {
		disparo.Clear();
		disparo.setDato(numTransicion, 0, 1);

	}

	// dispara la el numero de transicion
	public void ejecutar(int disparar) {
		colocarUno(disparar);
		auxiliar = Incidencia.mult(disparo);
		auxiliar = marcado.plus(auxiliar);
		marcado = auxiliar;

		// System.out.println(marcado.toString()+"......"+disparar);

	}

	public boolean disparoPosible(int disparar) {
		colocarUno(disparar);
		auxiliar = Incidencia.mult(disparo);
		auxiliar = marcado.plus(auxiliar);
		if (auxiliar.isPos()) {
			// System.out.println("Es posible el disparo");
			return true;
		} else {
			// System.out.println("El disparo no es posible");
			return false;
		}
	}

}
