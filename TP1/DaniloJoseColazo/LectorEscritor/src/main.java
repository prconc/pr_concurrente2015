
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Buffer b = new Buffer(25);
		
		for (int i=0;i<50;i++)
		{
			Escritor e = new Escritor(b,i,i%25);
			Thread t1 = new Thread(e);
			t1.start();
			
			Lector l = new Lector(b,i%25);
			Thread t2 = new Thread(l);
			t2.start();
			
		}
	}

}
