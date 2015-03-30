
public class VectorConcurrente {
	boolean escribiendo;
	int numLectores;
	int vector[];
	int size;
	
	VectorConcurrente(int size){
		escribiendo = false;
		numLectores=0;
		vector = new int[size];
		this.size = size;
	}
	
	public void escribir(int valor,int indice)
	{
		synchronized(this){
			while(escribiendo || (numLectores>0)) //Si ya hay alguien escribiendo o Lectores esperando para leer esperar
			{
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			escribiendo = true;
		}
		
		if(size > indice)
			vector[indice] = valor;		//EN este punto escribimos
		
		synchronized(this){
			escribiendo = false;
			notifyAll();
		}
		
		
	}
	
	public int leer(int indice)
	{
		synchronized(this)
		{
			while(escribiendo){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				numLectores++;
			}
		}
		int resultado = vector[indice]; //Aca estamos leyendo el dato del vector
		
		synchronized(this){
			numLectores--;
			if(numLectores == 0)
				notifyAll();
		}
		return resultado;
	}
	
}
