
public class Filosofo implements Runnable{

	Monitor monitor;
	Matrix disparo1, disparo2;
	int id;
	
	
	//el constructor de filosofo asigna los disparos a cada uno segun el id
	//que se le pase.
	public Filosofo(Monitor m,int d)
	{
		id = d;
		
		disparo1 = new Matrix(10,1);
		disparo2 = new Matrix(10,1);
		monitor = m;
		
		for(int i = 0; i<10; i++){
			disparo1.setDato(i, 0, 0);
			disparo2.setDato(i, 0, 0);
			
			if(i == d){
				disparo1.setDato(i, 0, 1);
			}
			
		}
		int[][]d1 = disparo1.getDato();
		for(int i = 0;i<5;i++){
			if (d1[i][0] == 1)
			{
				disparo2.setDato(5+i,0,1);
			}
		}

		
		
	}
	@Override
	public void run() {
		while(true){
			
			monitor.comer(disparo1,id);
			
			
			//sleep random entre 10 y 110 ms
			try {
				Thread.sleep((int)(10+Math.random()*(100)));
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			monitor.devolverPalillo(disparo2,id);
			
			//sleep random entre 10 y 110 ms
			try {
				Thread.sleep((int)(10+Math.random()*(100)));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	

}
