
public class Buffer {
	
	private static final int TAMAÑO = 10;
	
	int[] buffer;
	int consumidor;
	int productor;
	int counter = 0;
	
	public Buffer()
	{
		buffer = new int[TAMAÑO];
		
		for(int i = 0; i<TAMAÑO; i++){
			buffer[i] = 0;
		}
		
		consumidor= 0;
		productor=0;
		
	}
	
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
	
	public int incrementarPointer(int pointer)
	{
		pointer++;
		pointer = pointer%TAMAÑO;
		return pointer;
	}
	
	synchronized public void Print()
	{
		for (int i = 0; i<TAMAÑO; i++){
			
			System.out.print(buffer[i]);
			
		}
		
		System.out.println();
		
		
	}
	

	
	
	

}
