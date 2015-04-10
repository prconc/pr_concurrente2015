
public class Productor extends Thread{
	
	private Buffer b;
	private int pVel;
	
	public Productor(Buffer bu, int v)
	{
		b=bu;
		pVel=v;//tiempo que espera
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//tiempo que tarda antes de empezar a producir
			try {
				sleep(pVel);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b.producir();//genera recursos
		}
		
	}

}
