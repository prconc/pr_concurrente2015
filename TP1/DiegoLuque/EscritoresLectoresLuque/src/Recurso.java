
public class Recurso {
	int numLectores=0;
	boolean hayEscritor= false;
	
	public Recurso(){
	}
	
	public void leer(){
		
		//protocolo de entrada
		
		synchronized(this) {
			while(hayEscritor)
				try {
					wait();
				}
			catch (Exception e) {}
			numLectores++;
		}
		
		//letendo. Sin sincronizar para permitir concurrencia
		
		//protocolo de salida
		synchronized(this) {
			numLectores--;
			if (numLectores==0) notifyAll();
		}
	}
	
	synchronized public void escribir (){
		
		//protocolo de entrada
		synchronized (this) {
			while(hayEscritor || (numLectores>0))
				try{
					wait();
				}
			catch(Exception e) {e.printStackTrace();}
			hayEscritor=true;
		}
		
		//escribiendo. Sin sincronizar, pero solo habra un escritor
		
		//prtocolo de salida
		synchronized(this) {
			hayEscritor = false;
			notifyAll();
		}
	}
}
