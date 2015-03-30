
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buffer b;
		Consumidor c;
		Productor p;
		
		b = new Buffer();
		c = new Consumidor(b);
		p = new Productor(b);
		
		for(int i=0;i<50;i++){
			Thread t = new Thread(p);			
			t.start();
		}
		
		for(int i=0;i<20;i++){
			Thread t = new Thread(c);
			t.start();
		}
		System.out.println("Fin del hilo main");
	}

}
