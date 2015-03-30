
public class Buffer {
	int capacidad; 			//Contiene la capacidad del Buffer
	int[] valores;			//Contiene el arreglo de valores cargados
	int lastPos;			//Permite trackear las posiciones, realiza el overflow si se repasa el límite
	int cima;				//Cantidad de elementos escritos
	
	Buffer(){	capacidad = 10;				
				valores = new int[capacidad];
				cima = 0;
				lastPos = 0;
	}
	synchronized public void producir(int valor)
	{	
		//Aca nunca hay wait, debido a que si sobrepasa la capacidad se produce un overflow
		//y sobreescribe el primer valor
		valores[lastPos] = valor;	
		System.out.println("Agregando el valor " + valor + " en la posición " + lastPos + " del Buffer.");
		lastPos++;	//Cambia posicion del ultimo dato
		cima++;		//Aumento cantidad de datos disponibles
		lastPos = lastPos % capacidad;	//Por ser buffer circular
		if(cima>capacidad)
			cima = capacidad; //No puede haber mas de (capacidad) elementos, dsp de ese valor se sobreescribe
		notifyAll();	
	}
	
	synchronized public void consumir()
	{
		while(cima <= 0){
			try {
				wait();							//No hay valor para consumir, por lo tanto espera
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cima--;
		lastPos--;
		if(lastPos == -1){ //En caso de que haya hecho un overflow anterior
			lastPos = (capacidad-1);
		}
		System.out.println("Consumiendo el valor " + valores[lastPos] + " en la posición " + lastPos + " del Buffer.");
	}
}