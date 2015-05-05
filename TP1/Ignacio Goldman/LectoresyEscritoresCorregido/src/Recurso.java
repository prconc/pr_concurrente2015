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
		System.out.println("el lector esta leyendo");
		try{Thread.sleep(5000);}
		catch(InterruptedException e){}
		System.out.println("el lector termino de leer");
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
		System.out.println("el escritor esta escribiendo");
		try{Thread.sleep(5000);}
		catch(InterruptedException e){}
		System.out.println("el escritor termino de escribir");
		//termino de escribir
		hayEscritor = false;
		
		notifyAll();
	}
		
}
