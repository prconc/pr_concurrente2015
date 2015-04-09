public class Buffer {
	
	boolean escribiendo;
	int numLectores;
	int Libro[];
	int tamanio;
	
	Buffer(int tamanio){
		
		escribiendo = false;
		numLectores=0;
		Libro = new int[tamanio];
		this.tamanio = tamanio;
	}
	
	public void escribir(int valor,int registro)
	{
		synchronized(this){
			while(escribiendo || (numLectores>0))
			{
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("ERROR Escribir");
				}
			}
			escribiendo = true;
		}
		
		if(tamanio > registro)
			Libro[registro] = valor;		
		
		synchronized(this){
			escribiendo = false;
			notifyAll();
		}
		
		
	}
	
	public int leer(int registro)
	{
		synchronized(this)
		{
			while(escribiendo){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("ERROR Leer");
				}
				numLectores++;
			}
		}
		int lectura = Libro[registro];
		
		synchronized(this){
			numLectores--;
			if(numLectores == 0)
				notifyAll();
		}
		return lectura;
	}
	
}