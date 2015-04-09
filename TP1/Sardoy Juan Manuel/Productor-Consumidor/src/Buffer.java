
public class Buffer {
	
	private static final int TAMAÑO = 10;
	
	int[] buffer;
	int consumidor;
	int productor;
	int counter = 0;
	
	
	//El buffer es circular, tiene tamaño 10 y usa '1' y '0' para representar si el lugar en el buffer 
	//esta vacio o lleno.
	public Buffer()
	{
		buffer = new int[TAMAÑO];
		
		for(int i = 0; i<TAMAÑO; i++){
			buffer[i] = 0;
		}
		
		consumidor= 0;
		productor=0;
		
	}
	
	
	// la funcion push la usa el productor para poner un '1' en alguna posicion del buffer.
	synchronized public void push() throws InterruptedException{
		
		if(counter == TAMAÑO){
			wait();
		}
		
		else{
			
			buffer[productor] = 1;
			productor = incrementarPointer(productor);
			counter++;
			notify();
		}
		
		
	}
	//la funcion pop la usa el consumidor para "sacar" un '1' del buffer, poniendo en su lugar un cero.
	synchronized public void pop() throws InterruptedException{
		
		if(counter == 0){
			wait();
		}
		else{
			
			buffer[consumidor] = 0;
			consumidor = incrementarPointer(consumidor);
			counter--;
			notify();
			
			
		}
		
	
		
	}
	//esta funcion actualiza los indices que indican en que lugar tiene que poner o sacar el productor y el 
	//consumidor respectivamente.
	public int incrementarPointer(int pointer)
	{
		pointer++;
		pointer = pointer%TAMAÑO;
		return pointer;
	}
	
	//esta funcion se usa solamente para ver el estado del buffer, y ver como evoluciona con el tiempo.
	//esta sincronizado para que no cambie de estado mientras se imprime en la consola.
	synchronized public void Print()
	{
		for (int i = 0; i<TAMAÑO; i++){
			
			System.out.print(buffer[i]);
			
		}
		
		System.out.println();
		
		
	}
	

	
	
	

}
