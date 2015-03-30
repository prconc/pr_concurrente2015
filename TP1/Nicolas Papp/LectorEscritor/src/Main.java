import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VectorConcurrente v = new VectorConcurrente(10);
		
		Random rnd = new Random();
		
		
		
		for(int i=0; i<100;i++)
		{
		    int num = rnd.nextInt(10);
	        int num2 = rnd.nextInt(100);
	        
			Escritor e= new Escritor(v, num2,num);
			Thread t2 = new Thread(e);
			t2.start();
			
			Lector l = new Lector(v, num);
            Thread t= new Thread(l);
            t.start();
		}
	}

}
