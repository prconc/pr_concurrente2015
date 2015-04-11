public class Filosofo implements Runnable {

	int quienSoy=0;
	Palito palDer,palIzq;
	Contador cont;
	int numeroOperaciones=10;
	
	public Filosofo(int quienSoy, Contador cont, Palito palDer, Palito palIzq){
		this.quienSoy=quienSoy;
		this.cont=cont;
		this.palDer=palDer;
		this.palIzq=palIzq;
		}
	
	public void run() {
		for(int i=0;i<numeroOperaciones;i++){
			System.out.println ("Filosofo " +quienSoy+" pensando");
			cont.inc();
			palDer.agarrar();
			palIzq.agarrar();
			System.out.println ("Filosofo "+quienSoy+" comiendo");
			palDer.soltar();
			palIzq.soltar();
			cont.dec();
		}
	}

}
