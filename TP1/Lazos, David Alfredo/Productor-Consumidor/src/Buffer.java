

public class Buffer {
	private int cima, capacidad, vector[];
	
	Buffer (int i){
		cima=0;
		capacidad=i;
		vector=new int[i];
	}
	synchronized public int extraer() {
		while(cima==0)
			try{
				wait();
			} catch (InterruptedException e){
				e.printStackTrace();
				}
	    notifyAll();
	    return vector[--cima];
	}

	synchronized public void insertar(int elem){
		while(cima==capacidad-1)
			try{
				wait();
			} catch (InterruptedException e){
				e.printStackTrace();
				}
		vector[cima]=elem;
		cima++;
		notifyAll();
	}
}