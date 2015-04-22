
public class Buffer {

	int producto=0;
	
	public Buffer(){
	
	}
	
	public synchronized void Consumir(){
		producto--;
		System.out.print("Consumo, queda "+producto+" productos \n");
		
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public synchronized void Producir(){
		producto++;
		System.out.print("Producir,hay "+producto+" productos "+"\n");
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
