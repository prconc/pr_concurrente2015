
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Buffer b = new Buffer(20);
		
		int cVelocidad=500;
		int pVelocidad=100;
		
		Consumidor c= new Consumidor(b,cVelocidad);
		Productor p = new Productor(b,pVelocidad);
		

		p.start();
		c.start();
	}

}
