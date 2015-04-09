
public class Contador {
	
	int cuenta;
	int max;
	public Contador(int max){
		this.max = max;
	}
	
	synchronized public void incrementar(){
		if(cuenta == max){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cuenta++;
		
	}
	
	synchronized public void decrementar(){
		
		//System.out.println("CUENTAAAAAAAAAA " + cuenta);
	
		cuenta--;
		notifyAll();
		
	}

}
