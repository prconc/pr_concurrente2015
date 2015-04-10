
public class Buffer {
	private int maximo;
	private int capacidad;
	private int buffer[];
	
	Buffer(int elementoagregar){
		maximo=0;
		capacidad=elementoagregar;
		buffer= new int [elementoagregar];
								}
	
	synchronized public int quitar(){
		while (maximo==0)
			try {
				wait();
				} 
			catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
											}
			notifyAll();
			return buffer[--maximo];
									}
	synchronized public void agregar(int elementoagregar, int alea){
		while(maximo== capacidad-1)
			try {
				wait();
				} 
			catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
											}
		buffer[maximo]=alea;
		maximo++;
		notifyAll();
																	}
					}

