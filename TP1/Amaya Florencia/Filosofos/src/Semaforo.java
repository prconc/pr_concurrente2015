	/*Practico numero 1, problema de los filosofos, programacion concurrente 2014
	 *Alumnos: Guillermo Johnston    35886421
	 *         lucas     Almendros   36354785
	 */
public class Semaforo {
	
	public Semaforo() {
		// TODO Auto-generated constructor stub
	}
	
	/*Si algún palillo que necesita el filósofo está siendo usado, el filósofo espera
	 * Si tiene los 2 palillos libres el filósofo come.
	 */
	public synchronized void Wait(Palillo[] a, int r, int l)
	{
		while(!((a[r].getLibre())==true && (a[l].getLibre())==true))
		{
			try 
			{
				wait();
			}
			
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		a[r].setLibre(false);
		a[l].setLibre(false);
		System.out.println("Filosofo " + r + " COMIENDO");
	}
	
	/*Cuando el filósofo termina de comer deja los palillos 
	  , seteandolos en true (Disponible), además despierta 
	  todos los otros filosofos que esten esperando para comer
	*/
	public synchronized void Signal(Palillo[] a, int r, int l)
	{
		a[r].setLibre(true);
		a[l].setLibre(true);
		notifyAll();
		System.out.println("Filosofo " + r + " Dejo de comer");
	}
}
