public class Palillo {
	boolean disponible;
	
	Palillo(){
		disponible = true;
		}
	
	synchronized public void tomarPalillo(int n_filosofo){
		if(!disponible){
			try{
				wait();
			}catch(Exception e){}
		}
		System.out.println("el filosofo "+n_filosofo+" ha tomado el palillo");
		disponible = false;
		}
	
	synchronized public void soltarPalillo(){
		disponible = true;
		notifyAll();
	}
	
}
