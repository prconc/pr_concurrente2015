
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub}
		 Buffer buffer=new Buffer (5);
		
		for(int i=0;i<5;i++){
		
				
				Productor prod = new Productor (buffer, i);
				Thread H1= new Thread (prod);
				H1.start ();
				
				
				Consumidor cons= new Consumidor (buffer, i);
				Thread H2= new Thread (cons);
				H2. start ();
							}
			System.out.println("Fin del hilo main");

											}
		
				}
