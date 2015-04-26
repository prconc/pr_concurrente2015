
public class Filosofo extends Thread{
	int quiensoy = 0;
	Palillo palder, palizq;
	Contador cont;
	int numoperaciones = 10;
	
	public Filosofo(int _quiensoy, Contador _cont, Palillo _palder, Palillo _palizq ) {
		quiensoy = _quiensoy;
		cont     = _cont;
		palder   = _palder;
		palizq   = _palizq;		
	}
	
	public void run () {
		
		for (int i=0; i<numoperaciones; i++) {
			
			System.out.println("Filosofo "+ quiensoy + " pensando");
			cont.inc();
			palder.tomar(quiensoy);
			palizq.tomar(quiensoy);
			System.out.println("Filosofo "+ quiensoy + " comiendo");
			palder.soltar();
			palizq.soltar();
			cont.dec();			
		}
	}

}
