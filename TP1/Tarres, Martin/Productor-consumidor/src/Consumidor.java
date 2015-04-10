
public class Consumidor implements Runnable {
	int elementoagregar=0;
	Buffer buffer;
	
	
	Consumidor(Buffer buffer, int elementoagregar){
		this.buffer=buffer;
													}
	
	public void run(){
		while(true){
			try{
			elementoagregar=buffer.quitar();
				}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
							}
		System.out.println("Consumidor consumio "+ elementoagregar);
					}
						}
												}