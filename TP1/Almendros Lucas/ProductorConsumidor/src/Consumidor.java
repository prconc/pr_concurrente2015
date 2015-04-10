
public class Consumidor extends Thread{
	
	private Buffer b;
	private int cVel;
	
	public Consumidor(Buffer bu, int v)
	{
		cVel = v;//tiempo que espera
		b=bu;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//tiempo que tarda antes de empezar a consumir
			try {
				sleep(cVel);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b.consumir();//consume los recursos
		}
		
	}

}
