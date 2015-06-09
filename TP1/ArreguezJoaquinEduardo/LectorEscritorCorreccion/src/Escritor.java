//Los datos a escribir son siempre el mismo String de prueba
//Se usa un String como identificador del escritor
public class Escritor implements Runnable {
	
	String nombre;
	listaConcurrente lista;

	public Escritor(String nombre, listaConcurrente lista) {
		this.nombre=nombre;
		this.lista= lista;
	}

	@Override
	public void run() {
		listaConcurrente.print(nombre+" quiere escribir.");
		lista.escribir("Aquí poema del autor "+nombre);
		listaConcurrente.print(nombre+" está satisfecho con su publicación!");
		
	}

}
