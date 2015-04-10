/*Practico numero 1, problema de los filosofos, programacion concurrente 2014
 *Alumnos: Guillermo Johnston    35886421
 *         lucas     Almendros   36354785
 */
public class Mesa {
	private Palillo[] palillos;
	private Semaforo semaforo;
	
	public Mesa(int j, Semaforo sem) 
	{
		//La mesa crea la cantidad de palillos de acuerdo a lo que requiera el problema.
		//En este caso 5, que es el parametro j.

		semaforo= sem;
		palillos = new Palillo[j];
		for(int i=0; i<j; i++)
		{
			palillos[i]=new Palillo();
		}
	}
	
	// llama a la funcion Wait del semaforo, para comprobar si puede comer
	public void comer(int r, int l)
	{
		 semaforo.Wait(palillos,r,l);
	}
	
	// llama a la funcion Signal del semaforo para ver 
	//si otro filosofo puede comer de los que estan eperando
	public void dejarDeComer(int r, int l)
	{
		semaforo.Signal(palillos,r,l);
	}

}
