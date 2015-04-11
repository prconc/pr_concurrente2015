public class Semaforo {
    protected int contador=0;
    
    public Semaforo(int valorInicial){
    	contador=valorInicial;
    }

    synchronized public void WAIT(){
    	while(contador==0){
    		try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		contador--;
       }
    }
    synchronized public void SIGNAL(){
    	contador++;
    	notify();
    }
}
