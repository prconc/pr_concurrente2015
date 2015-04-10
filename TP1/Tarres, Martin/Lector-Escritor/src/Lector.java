
public class Lector implements Runnable{
	
	
	Buffer buffer;
	int lector;
	
	public Lector (Buffer buffer, int lector){
		
	this.lector=lector;
	this.buffer=buffer;
		
												}

	public void run(){
		int i=0;
		while (i<10){
			System.out.println("El lector " + lector+" leyo." );
			buffer.leer();
			i++;
			
			
			
					}
						}
										}