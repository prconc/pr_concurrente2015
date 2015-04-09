
public class Productor implements Runnable {
	
	Buffer buff;
	
	public Productor(Buffer b){
		
		buff = b;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			
			try {
				for(int i = 0; i< 1; i++)
				{
					buff.push();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			buff.Print();
			//System.out.println(buff.counter);
			try {	
				int t =10+ (int)(Math.random()*(101));
				Thread.sleep(t);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
