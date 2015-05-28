
public class Semaforo {
	
	protected int contador=0;
	
	public Semaforo(int valorInicial){
		contador=valorInicial;
	}
	synchronized public void WAIT(){
		while(contador==0)
			try{
				wait();
			}
		catch(Exception e){}
		contador--;
	}
	
	synchronized public void SIGNAL() {
		contador=1;
		notify();
	}
}