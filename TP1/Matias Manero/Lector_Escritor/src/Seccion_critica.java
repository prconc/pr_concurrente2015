
public class Seccion_critica {
	
	public Seccion_critica(){
	
	}
	
	public synchronized void leyendo(){
		
		System.out.println("Entre estoy leyendo \n");
		
		try {
			Thread.sleep(50);
			} catch (Exception e) {
			// TODO: handle exception
			}
			
		
		
	}
	
	public synchronized void escribiendo(){
		
	System.out.println("Entre estoy escribiendo \n");
	
	try {
		Thread.sleep(50);
		} catch (Exception e) {
		// TODO: handle exception
		}
		
		
	}
	

}
