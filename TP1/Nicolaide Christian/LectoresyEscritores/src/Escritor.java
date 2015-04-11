public class Escritor implements Runnable {
	VectorConcurrente v;
	int indice;
	int valor;

	Escritor(VectorConcurrente v, int valor, int indice) {
		this.v = v;
		this.indice = indice;
		this.valor = valor;
	}

	public void run() {
		// TODO Auto-generated method stub
		v.escribir(valor, indice);
		System.out.println("Escribiendo el valor " + valor + " en la posicion "
				+ indice);
	}
}
