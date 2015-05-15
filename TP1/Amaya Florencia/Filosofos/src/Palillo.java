/*Practico numero 1, problema de los filosofos, programacion concurrente 2014
 *Alumnos: Guillermo Johnston    35886421
 *         lucas     Almendros   36354785
 */

//Clase palillo, solo tiene una variable(libre) que indica si esta siendo usado o libre.
public class Palillo {
	private boolean libre;
	Palillo ()
	{
		setLibre(true);
	}
	
	public boolean getLibre() {
		return libre;
	}
	
	public void setLibre(boolean libre) {
		this.libre = libre;
	}
}
