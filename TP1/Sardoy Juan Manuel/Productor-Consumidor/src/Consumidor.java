
public class Consumidor implements Runnable{
	
	Buffer buff;
	
	public Consumidor(Buffer b){
		
		buff = b;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			
			try {
				for(int i = 0; i< 1; i++)
				{
					buff.pop();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 buff.Print();
			
			//sleep random entre 10 y 100 milisegundos
			try {
				int t = 10 + (int)(Math.random()*(101));
				Thread.sleep(t);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
