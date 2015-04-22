public class Contador {
	int __cont__;
	int __tope__;
	
	public Contador(int tope){
		__cont__ = 0;
		__tope__ = tope;
	}
	
	public synchronized void incrementar(){
		while(__cont__ == __tope__){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		__cont__++;
	}
	
	public synchronized void decrementar(){
		__cont__--;
		notifyAll();
	}
	
	public int valor(){
		return __cont__;
	}
}
