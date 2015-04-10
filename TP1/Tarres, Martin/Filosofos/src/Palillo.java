
public class Palillo {
	boolean palillolibre;
	
	Palillo(){
	
		palillolibre=true;
			}
	synchronized public void agarrar(){
		while(!palillolibre){
			try{
				wait();
				} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
											}
			
							}
		palillolibre=false;
		
										}
	synchronized public void soltar(){
		palillolibre=true;
		notifyAll();
									}
	

						}
