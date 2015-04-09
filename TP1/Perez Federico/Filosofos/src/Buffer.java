/* Se llama buffer pero representan los tenedores disponibles
 * Seria un buffer de tenedores.
 */


public class Buffer {
	
	private int tenedores[] = new int[5];									//Arreglo de cinco lugares.
	
	public Buffer(){for(int i=0;i<5;i++) {tenedores[i]= 1;}}				//Se carga con unos. Un uno es un tenedor disponible.

	public synchronized void devolver(int posicion) {tenedores[posicion]=1;}	//Devuelve un tenedor a su lugar en la mesa.
	
	public synchronized void sacar(int posicion) {tenedores[posicion]=0;}		//Toma un tenedor del lugar de la mesa.
	
	public synchronized int verTenedor(int posicion){return tenedores[posicion];}	//Devuelve si tiene un tenedor disponible en la posicion pedida.
	
	
}