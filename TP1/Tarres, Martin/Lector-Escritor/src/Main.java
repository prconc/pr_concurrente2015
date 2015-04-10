
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub}
		Buffer buffer= new Buffer ();
		
		for(int i=0; i<3;i++) {
			
			Lector lector = new Lector (buffer, i);
			Thread T1= new Thread (lector);
			T1.start ();
			
			
			Escritor escritor= new Escritor ( buffer, i);
			Thread T2= new Thread (escritor);
			T2. start ();
			
			
								}
		
											}

				}
