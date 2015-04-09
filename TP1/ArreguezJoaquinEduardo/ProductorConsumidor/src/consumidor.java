
public class consumidor implements Runnable {
	
	buffer b;

	public consumidor(buffer b) {
		this.b=b;
	}

	@Override
	public void run() {
		try{b.consumir();}
		catch(Exception e){e.printStackTrace();}
		
		buffer.print("Éste thread se va a dormir 100 ms");
		try {
			Thread.currentThread();
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		buffer.print("Éste thread se despertó y se fue nomas..");
		
		return;
	}

}
