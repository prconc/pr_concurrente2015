
public class Monitor {

	private Palillos buffer;
	private VarCond Cond1;
	private Semaforo mutex;
	private Procesador_Petri petri;
	
	
	
	public Monitor (Palillos buffer, Procesador_Petri red)
		{
		this.buffer=buffer;
		mutex=new Semaforo(1,true,"mutex");
		Cond1 = new VarCond(mutex);
		petri=red;
		
		}

	public void pensando(int id){
		System.out.println("Filosofo: " + id +" Pensando."); 
		
	}



	public void comiendo(int id, int[] disparo)	
	{
		Cond1.EXCLUCION_wait(); 
		
	
		while(petri.ejecutar(disparo))
		{   
			Cond1.DELAY();
			
		}
		
		System.out.println("Filosofo:  " + id +" Comiendo."); 
		
		Cond1.EXCLUCION_signal();
	}	
		
	public void devolver(int id, int[] disparo){
	
		Cond1.EXCLUCION_wait(); 
	
		 petri.ejecutar(disparo);
	
	    
	System.out.println("Filosofo: " +id +", termino de comer.");    
		
		Cond1.RESUME();
		
		Cond1.EXCLUCION_signal();
	
	}
	
}
