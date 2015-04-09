
public class Escritor implements Runnable {
	
	Buffer oBuffer;
	int registro;
	int valor;
	
	Escritor(Buffer oBuffer, int valor, int registro){
		
		this.oBuffer = oBuffer;
		this.registro = registro;
		this.valor = valor;
	}

	public void run() {
		// TODO Auto-generated method stub
		
	    oBuffer.escribir(valor, registro);
		System.out.println("Se escribió el valor " + valor + " en el registro " + registro);
	}
}
