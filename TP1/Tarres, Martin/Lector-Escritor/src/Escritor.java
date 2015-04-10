
public class Escritor implements Runnable{//buscar para meterle una variable aleatoria y ver como cambia!
	
	Buffer buffer;
	int escritor;
	
	public Escritor (Buffer buffer, int escritor){
		
	this.escritor=escritor;
	this.buffer=buffer;

												}

	public void run(){
		
		int i=0;
		while (i<10){
			System.out.println("Escritor " + escritor+ " escribio"  );
			buffer.escribir();
			System.out.println("Escritor " + escritor+ " termino de escribir"  );
			i++;
					}
						}
										}