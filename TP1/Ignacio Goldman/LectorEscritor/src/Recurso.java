public class Recurso {
	int numero_lectores;
	boolean hayEscritor;
	
	public Recurso(){
		numero_lectores = 0;
		hayEscritor = false;
			
	}
	
	public void leer(){ 
		synchronized(this){
			if(hayEscritor){
				try{
					wait();
				}
				catch(InterruptedException e){}
			}
			numero_lectores++;
		}	
		
		//simula que esta leyendo
		try{Thread.sleep(1000);}
		catch(InterruptedException e){}
		//termino de leer
		synchronized(this){
			numero_lectores--;
			if(numero_lectores == 0){
				notifyAll();
			}
		}	
	}	
		
	synchronized public void escribir(){
		if(hayEscritor || numero_lectores > 0){
			try{
				wait();
			}
			catch(InterruptedException e){}
		}
		
		hayEscritor = true;
		//simula que esta escribiendo
		try{Thread.sleep(1000);}
		catch(InterruptedException e){}
		//termino de escribir
		hayEscritor = false;
		
		notifyAll();
	}
		
}
