

/**
 * 
 */

/**
 * @author Carlos
 *
 */
public class MonitorSem implements MonitorInterface {

	private Olla olla;
	
	private Semaforo lock = new Semaforo(1,true,"lock");			//lock para exclusi�n mutua
	private Semaforo llenar = new Semaforo(0,true,"llenar");			//Condicion donde espera el cocinero.
	private Semaforo vacia=  new Semaforo(0,true,"vacia");;			//condicion donde esperan los salvajes.
	
	private int waiting=0;// numero de salvajes esperando
	
	public MonitorSem(Olla olla) {
		super();
		this.olla = olla;
	}

	/* (non-Javadoc)
	 * @see MonitorInterface#cocinar()
	 */
	@Override
	public void cocinar() throws InterruptedException {
		lock.WAIT();
		
		if (waiting==0 || olla.getCapacidad()==olla.getMisioneros()) {//Si nadie espera o la olla esta llena espera.
			System.out.print("cocinero duerme\n");
			
			lock.SIGNAL();
			llenar.WAIT();       //hace esperar a los thread que estan esperando por esta condicion
			lock.WAIT();
		}
		olla.setMisioneros(olla.getMisioneros()+1);
		System.out.print("cocinero , hay "+olla.getMisioneros()+"\n");
		if(olla.getCapacidad()==olla.getMisioneros()) {// Si la olla esta llena notifico.
			vacia.SIGNAL();       //avisa a los thread pueden reanudar su ejecucion
			lock.SIGNAL();
			llenar.WAIT();       //hace esperar a los thread que estan esperando por esta condicion
			lock.WAIT();
		}
		lock.SIGNAL();
	}

	/* (non-Javadoc)
	 * @see MonitorInterface#comer()
	 */
	@Override
	public void sacarMisionero() throws InterruptedException {
		lock.WAIT();

		if(waiting>0) {// Si hay otros esperando no verifico simplemente espero
			waiting++;
			System.out.print("espera\n");
			lock.SIGNAL();
			vacia.WAIT();			//Me pongo en la cola
			lock.WAIT();
			waiting--;
		}

		while(olla.getMisioneros() == 0){		//La olla esta vacia:
			waiting++;			//Aviso que hay gente esperando.
			System.out.print("salvaje despierta cocinero y espera\n");
			llenar.SIGNAL();		//Despierto al cocinero.
			lock.SIGNAL();			// libero el lock, luego de esto no puedo tocar las variables hasta obtenerlo nuevamente
			vacia.WAIT();			//Me pongo en la cola
			lock.WAIT();
			waiting--;			//Si llego a este punto quiere decir que me despertaron pq la olla esta llena.
		}

		olla.setMisioneros(olla.getMisioneros()-1);				//como 1 misionero
		System.out.print("salvaje come, quedan "+ olla.getMisioneros()+"\n");

		if(waiting>0)vacia.SIGNAL();       		//aviso a otro salvaje que puede comer.

		lock.SIGNAL();
	}

}
