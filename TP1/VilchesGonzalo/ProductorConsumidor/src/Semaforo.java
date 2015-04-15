
public class Semaforo {
private int lleno;

public Semaforo(int l)
{
 lleno=l;
}

public synchronized void WAIT()
{
while( lleno==0 ){	  
	try {
		wait();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
 {
	lleno=lleno-1;
     }
}		
	
public synchronized void SIGNAL() 
{

		lleno=lleno+1;
		notifyAll();
	
	
}


public int get_valor(){
	return lleno;
}

}
