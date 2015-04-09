import java.util.Random;

public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Buffer oBuffer = new Buffer(10);
		
		Random oRandom = new Random();
		
		
		for(int i=0; i<100;i++)
		{
		    int registro = oRandom.nextInt(10);
	        int valor = oRandom.nextInt(100);
	        
			Escritor e= new Escritor(oBuffer, valor,registro);
			Thread t1 = new Thread(e);
			t1.start();
			
			Lector l = new Lector(oBuffer, registro);
            Thread t2= new Thread(l);
            t2.start();
		}
	}

}
