

public class Buffer {
	private int cantidad;//tamaño del buffer
	private int consumiendo;//en donde esta consumiendo en el vector
	private int produciendo;//en donde esta produciondo en el vector
	private int[] buffer;// el buffer, contiene "cant" de espacio, un 1 significa que el espacio esta ocupado,
						 //un o es que esta disponible
	private int total;//cantodad de espacios ocupados
	
	public Buffer(int cant)
	{
		cantidad = cant;
		buffer = new int[cant];
		for(int i=0; i<cant; i++)//inicializo el buffer vacio(todos 0)
		{
			buffer[i]=0;
		}
		total=0;
		consumiendo=0;
		produciendo=0;
	}
	
	synchronized public void consumir(){//si no hay recursos sale, 
									   //si no el consumidor roba recursos, 
	                                  //carga un 0 en la dirección del buffer elegido 
		if(total > 0)
		{
			buffer[consumiendo]=0;
			total--;
			if(consumiendo != cantidad-1)// el buffer es circular, por ende debe comprobar si esta en
										// ultimo indice del biffer
			{
				consumiendo++;
			}
			else
			{
				consumiendo = 0;
			}
		}
		System.out.println("en stock: " + total+ "\n");
	}
	
	synchronized public void producir()//genera recursos si es que hay espacio en el buffer
	{
		if(total < cantidad)
		{
			buffer[produciendo]=1;
			total++;
			if(produciendo != cantidad-1)// el buffer es circular, por ende debe comprobar si esta en
										// ultimo indice del biffer
			{
				produciendo++;
			}
			else
			{
				produciendo =0;
			}
		}
		System.out.println("En stock: " + total+ "\n");
	}
}
