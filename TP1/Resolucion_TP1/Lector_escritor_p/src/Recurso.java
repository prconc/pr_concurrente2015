
public class Recurso {

	int numlectores = 0;
	boolean hayescritor = false;

	public Recurso() {
	}
	
	public void leer(){
		// Protocolo de entrada
		synchronized(this){
			while(hayescritor)
				try{
					wait();
				} catch (Exception e) {}
			numlectores++;
		}
			
		// Leyendo. Sin sincronizar para permitir concurrencia.
		
		// Protocolo de salida.
		synchronized(this){
			numlectores--;
			if (numlectores==0) { 
				notifyAll();
			}
		}
	}

	
	
	synchronized public void escribir(int elem) {
		// Protocolo de entrada.
		synchronized (this){
			while(hayescritor || numlectores>0){
				try{
					wait();
				} catch (Exception e) {e.printStackTrace();}
			}
			hayescritor = true;
		}
		
		// Escribiendo. Sin sincronizar, pero solo habra un escritor.
				
		// Protocolo de salida.
		synchronized (this){
			hayescritor = false;
			notifyAll();
		}
	}

}
