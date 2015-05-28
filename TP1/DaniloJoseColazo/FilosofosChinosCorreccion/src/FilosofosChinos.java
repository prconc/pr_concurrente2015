

public class FilosofosChinos extends Thread
{
	int numeroDeFilosofo;
	int numeroDeOperaciones = 10;
	Palitos palito_Derecho, palito_Izquierdo;
	Contador cuenta;

	public FilosofosChinos(int numeroDeFilosofo,Palitos palito_Derecho,
						   Palitos palito_Izquierdo,Contador cuenta)
	{
		this.numeroDeFilosofo = numeroDeFilosofo;
		this.palito_Derecho = palito_Derecho;
		this.palito_Izquierdo = palito_Izquierdo;
		this.cuenta = cuenta;
	}
	
	public void run ()
	{
		for(int i=0; i<numeroDeOperaciones; i++)
		{
			System.out.println("Filosofo "+numeroDeFilosofo+" pensando");
			
			cuenta.incrementar();
			palito_Derecho.tomarPalito(numeroDeFilosofo);
			palito_Izquierdo.tomarPalito(numeroDeFilosofo);
			
			System.out.println("Filosofo "+numeroDeFilosofo+" comiendo");
			
			palito_Derecho.soltarPalito();
			palito_Izquierdo.soltarPalito();
			cuenta.decrementar();
		}
	}
}
