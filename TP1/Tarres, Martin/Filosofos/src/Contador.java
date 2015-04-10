
public class Contador {
	int contador;
	int maximo;
	
	Contador(int maximo){
		this.maximo=maximo;
		contador=0;
						}
	synchronized public void incrementa(){
		while(contador==maximo){
			try{
				wait();
				}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
								}
			
								}
		contador++;
										}
	synchronized public void decrece(){
		contador--;
		notifyAll();
									  }
	
					}
