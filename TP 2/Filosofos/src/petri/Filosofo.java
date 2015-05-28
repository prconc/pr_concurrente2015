package petri;

public class Filosofo implements Runnable{
	
	Monitor m;
	int quienSoy;
	int numEj;
		
	public Filosofo(int quienSoy,int _numEj, Monitor _m)
	{
		this.quienSoy=quienSoy;
		numEj=_numEj;
		m=_m;
	}
	
	
	public void run()
	{
		for(int i=0;i<numEj;i++){

			try {
				
				Thread.sleep(50);
				m.comer(quienSoy);
			} catch (InterruptedException e) {
				
				e.printStackTrace();}
						
			
			try {
				Thread.sleep(500+(int)Math.random()*1000);
				m.devolver_palillos(quienSoy);
			} catch (InterruptedException e) {
				e.printStackTrace();			
				}
		}
		System.out.println("Filosofo" + quienSoy +" ha finalizado");

	
	}
}
