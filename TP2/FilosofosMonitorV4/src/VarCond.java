
public class VarCond {

	private Semaforo s_cola;
	private Semaforo s_mutex;
	private int bloqueados;
	
	public VarCond(Semaforo mutex)
	{
		bloqueados=0;
		s_cola=new Semaforo(0,true,"s_cola");
		s_mutex=mutex;
	}
	
	public void DELAY()
	{
		bloqueados++;
		//liberar_exclusion 
		s_mutex.SIGNAL();
		s_cola.WAIT();
		s_mutex.WAIT();
		bloqueados--;
		
		
		            
	}
	
	public void RESUME(){

		if(bloqueados>=1)
		{
		s_cola.SIGNAL();
		}
	}
	
	public void EXCLUCION_wait(){
		s_mutex.WAIT();
	}
	public void EXCLUCION_signal(){
		s_mutex.SIGNAL();
	}
		
	
	
}
