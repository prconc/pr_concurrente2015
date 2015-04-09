public class Buffer {
	
	private int tenedores[] = new int[5];
	
	public Buffer(){for(int i=0;i<5;i++) {tenedores[i]= 1;}}

	public synchronized void devolver(int posicion) {tenedores[posicion]=1;}
	
	public synchronized void sacar(int posicion) {tenedores[posicion]=0;}
	
	public synchronized int verTenedor(int posicion){return tenedores[posicion];}
	
	
}