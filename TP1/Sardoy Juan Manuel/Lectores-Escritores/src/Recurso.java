
public class Recurso {
	
	int recurso;
	boolean hayEscritor;
	int numLectores;
	
	public Recurso(){
		recurso = 0;
		hayEscritor = false;
		numLectores = 0;
	}
	
	public void leer(String id){
		
		synchronized(this){
			
			if(hayEscritor){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			String str = String.format("Lector %s entra a leer",id);
			System.out.print(str);
			System.out.println();
			
		
			numLectores++;
			
		}
			
		System.out.println("NUMERO DE LECTORES " + numLectores);
		try {
			Thread.sleep((int)(10+Math.random()*(100)));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		synchronized(this){
			numLectores--;
			String str = String.format("Lector %s leyo %s",id,recurso);
			
			System.out.print(str);
			System.out.println();
			if(numLectores == 0){
				notifyAll();
			}
				
		}
		
	
	}
	
	synchronized public void escribir(String id,int a){
		
		if(hayEscritor || numLectores>0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
		hayEscritor = true;
		
		String str = String.format("Escritor %s entra a escribir el numero %s",id,a);
		System.out.print(str);
		System.out.println();
		recurso = a;
		
		
		hayEscritor = false;
		str = String.format("Escritor %s escribio el numero %s",id,a);
		System.out.print(str);
		System.out.println();
		notifyAll();
		
		
		
		
		
	}

}
