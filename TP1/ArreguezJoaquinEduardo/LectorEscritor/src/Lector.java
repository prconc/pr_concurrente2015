
public class Lector implements Runnable {
	
	String nombre;
	listaConcurrente lista;
	int indice;

	public Lector(String nombre,listaConcurrente lista,int indice) {
		this.lista=lista;
		this.nombre=nombre;
		this.indice=indice;
	}

	@Override
	public void run() {
		listaConcurrente.print(nombre+" está con ganas de leer...");
		listaConcurrente.print(nombre+" leyó "+lista.leer(indice));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
