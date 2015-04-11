
public class Recurso {

	int lectores=0;
	boolean hayEscritor=false;
	
	public Recurso(){
		}
	public void leer(){
		synchronized (this){
			while(hayEscritor)
				try{
					wait();
				}
			catch (Exception e){}
			lectores++;
		}
	    synchronized (this){
	    	lectores--;
	    	if(lectores==0){
	    		notifyAll();
	    	}
	    }	
	}
	synchronized public void escribir(){
		synchronized (this){
			while(hayEscritor||(lectores>0)){
				try{
					wait();
				}
				catch (Exception e){e.printStackTrace();}
				hayEscritor=true;
			}
		}
	
	
	synchronized(this){
		hayEscritor=false;
		notifyAll();
	}
  }
}
		







