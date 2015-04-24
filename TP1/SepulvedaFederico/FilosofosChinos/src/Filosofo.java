
public class Filosofo extends Thread {
	int quienSoy=0;
	Palillo palDer, palIzq;
	Contador cont;
	int numeroOperaciones=10;
	

	public Filosofo(int quienSoy, Contador cont, Palillo palDer, Palillo palIzq) {
		this.quienSoy=quienSoy;
		this.palDer=palDer;
		this.palIzq=palIzq;
		this.cont=cont;
	}

	public void run(){
		for (int i=0;i<numeroOperaciones;i++){
			System.out.println("Filosofo "+quienSoy+" pensando");
			cont.inc();
			palDer.agarrar(quienSoy);
			palIzq.agarrar(quienSoy);
			System.out.println("Filosofo "+quienSoy+" comiendo");
			palDer.soltar();
			palIzq.soltar();
			cont.dec();
		}
	}
}
