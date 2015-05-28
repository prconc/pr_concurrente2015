

public class MainFilosofosChinos 
{
	int cantidadDeFilosofos = 5;
	FilosofosChinos filosofos[] = new FilosofosChinos[5];
	Palitos palitos[] = new Palitos[5];
	Contador contador;

	public MainFilosofosChinos()
	{
		contador = new Contador(cantidadDeFilosofos-1);
	
		for(int i=0; i<cantidadDeFilosofos; i++)
		{
			palitos[i] = new Palitos();
		}
	
		for(int i=0; i<cantidadDeFilosofos; i++)
		{
			filosofos[i] = new FilosofosChinos(i,palitos[i],
						    			   palitos[(i+1)%cantidadDeFilosofos],contador);
			filosofos[i].start();
		}
	
		for(int i=0; i<cantidadDeFilosofos; i++)
		{
			try
			{
				filosofos[i].join();
			}
			catch(Exception e){}
		}
	}
	
	public static void main(String args[]) 
	{
		new MainFilosofosChinos();
	}

}
