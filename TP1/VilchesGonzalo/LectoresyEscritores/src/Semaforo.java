
public class Semaforo {
private int lleno;
boolean stop;

public Semaforo(int l)
{
 lleno=l;
 stop=false;
}

public synchronized void WAIT()
{
while( lleno==0 ){	  
	try {
		//System.out.println(" ");
		wait();
		stop=true;
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
 {
	 //System.out.println(" 2 ");
	lleno=lleno-1;
     }
}		
	
public synchronized void SIGNAL() 
{

	   // System.out.println(" SIGNAL");
		lleno=lleno+1;
		stop=false;
		notifyAll();
	
	
}

public boolean getBool()
{
	return stop;
}

public void changeBoolT()
{
	stop=true;
}

public void changeBoolF()
{
	stop=false;
}

}

