import java.util.Random;

public class Productor implements Runnable {
	
Buffer buffer;
int elementoagregar=0;

	public Productor(Buffer buffer, int elementoagregar){
		this.buffer= buffer;
		this.elementoagregar= elementoagregar ;
				
														}
	
	public void run(){
		System.out.println("Productor produciendo "+ elementoagregar);
		
		
		while(true){
			Integer alea = new Integer(new Random().nextInt(2));
			try{
				
			
			buffer.agregar(elementoagregar,alea);
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
							}
		System.out.println("Productor produjo "+ elementoagregar);
					}
		
						}
												}