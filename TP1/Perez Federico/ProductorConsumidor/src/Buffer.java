
public class Buffer {
	
	private char B[] = new char[10];
	private int input_index=0;						//variables de salida y entrada que se usan en un buffer circular.
	private int output_index=0;
		
	
	public Buffer()
	{
		for(int i=0;i<10;i++)
		{
			B[i]= '-';
		}
	}

	
	/*Metodo que incrementa o ingresa un elemento al buffer.
	 * Tiene un contador input_index que va aumentando tomando registro de por donde se van ingresando datos.
	 * Cuando no tiene mas lugar para incrementar se va a wait, 
	 * 
	 */
	
	public synchronized void inc()
	{
		if(input_index==10)
		{
			input_index=0;
		}
		if(B[input_index]=='O')
		{
			try
			{
            wait();
        	}catch(InterruptedException ex){}
		}
		
		B[input_index]='O';
		input_index++;
		System.out.print("\n");
		mostrarBuffer();
		System.out.print("\n");
		notify();
		
	}

	/*Este metodo funciona de forma similar a inc() y tambien se va a wait cuando no puede retirar elementos.
	 * 
	 */
	
	public synchronized void dec()
	{
		if(output_index==10)
		{
			output_index=0;
		}
		if(B[output_index]=='-')
		{
			try
			{
            wait();
        	}catch(InterruptedException ex){}
		}
		B[output_index]='-';
		output_index++;
		System.out.print("\n");
		mostrarBuffer();
		System.out.print("\n");
		notify();
		
	}
	
	
	public synchronized void mostrarBuffer()
	{
	
		for(int i=0;i<10;i++)
		{
			System.out.print(B[i]);
		}
	}
	

}