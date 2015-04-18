
public class Buffer {
	private int buff;                                        
	public Buffer(){
		buff=0;
	}
	
	public synchronized void incrementar() throws InterruptedException{
		
			buff=buff+1;
			System.out.println("Buffer(+) =" + buff);
	}
	public synchronized void decrementar() throws InterruptedException{
		
			buff=buff-1;
			System.out.println("Buffer(-) =" + buff);	
	}
}
