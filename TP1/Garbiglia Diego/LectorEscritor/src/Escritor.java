
public class Escritor implements Runnable{

	Buffer b;
	int indice;
	int dato;
	
	public Escritor(Buffer b, int dato, int indice)
	{
		this.dato = dato;
		this.indice = indice;
		this.b = b;
		
	}
	
	public void run()
	{
		b.escribir(dato, indice);
		
	}
	
	
	
}
