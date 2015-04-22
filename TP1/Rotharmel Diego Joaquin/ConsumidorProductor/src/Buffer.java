public class Buffer {
	private int __top__, __capacidad__, __vector__[];
	
	public Buffer(int i){
		__top__= 0;
		__capacidad__ = i;
		__vector__ = new int[i];
	}
	
	public synchronized void insertar(int elemento){
		while(__top__ == __capacidad__ - 1){
			try{
				wait();
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		__vector__[__top__] = elemento;
		__top__++;
		notifyAll();
	}
	
	public synchronized int extraer(){
		int valor;
		while(__top__ == 0){
			try{
				wait();
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		valor = __vector__[--__top__];
		return valor;
	}
}
