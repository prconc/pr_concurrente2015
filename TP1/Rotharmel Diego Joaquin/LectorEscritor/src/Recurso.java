public class Recurso {
	int __num_lectores__ = 0;
	boolean __hay_escritor__ = false;
	
	public void leer(){
		synchronized(this){
			while(__hay_escritor__){
				try{
					wait();
				} catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			__num_lectores__++;
		}
		
		synchronized(this){
			__num_lectores__--;
			if(__num_lectores__ == 0){
				notifyAll();
			}
		}
	}
	
	public synchronized void escribir(){
		synchronized(this){
			while(__hay_escritor__ || (__num_lectores__ > 0)){
				try{
					wait();
				} catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			__hay_escritor__ = true;
		}
		
		synchronized(this){
			__hay_escritor__ = false;
			notifyAll();
		}
	}
}
