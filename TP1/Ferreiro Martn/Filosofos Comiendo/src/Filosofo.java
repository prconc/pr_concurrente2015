
public class Filosofo implements Runnable{
	int quienSoy=0;
	Palillo palDer, palIzq;
	Contador cont;
	int numeroOperaciones=10;
	
	public Filosofo (int _quienSoy, Contador _cont, Palillo _palDer, Palillo _palIzq){
		quienSoy = _quienSoy;
		palDer= _palDer;
		palIzq= _palIzq;
		cont= _cont;
	}
	
	public void run(){
		for(int i=0;i<numeroOperaciones;i++){
			System.out.println("Filosofo "+quienSoy+" pensando");
			cont.inc();
			palDer.coger(quienSoy);
			palIzq.coger(quienSoy);
			System.out.println("Filosofo "+quienSoy+" comiendo");
			try {
				Thread.sleep(500+(int)Math.random()*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();			
				}
			palDer.soltar();
			palIzq.soltar();
			cont.dec();
		}
	}
}
