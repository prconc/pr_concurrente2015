
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buffer b = new Buffer(10);
		
		for(int i=0; i<100;i++)
		{ 
			
			Escritor e= new Escritor(b, i,(i+1)%100);
			Thread t2 = new Thread(e);
			t2.start();
			
			Lector l = new Lector(b, i);
            Thread t= new Thread(l);
            t.start();
		}
	}
}
