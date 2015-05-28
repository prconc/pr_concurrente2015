
public class Lector implements Runnable {
	
	Buffer oBuffer;
	int registro;
	
	Lector(Buffer oBuffer, int registro){
		
		this.oBuffer = oBuffer;
		this.registro = registro;
	}

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Se leyó el valor " + oBuffer.leer(registro) + " en el lugar " + registro);
		
	}
}