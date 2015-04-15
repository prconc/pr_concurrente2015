import java.util.Random; 

public class Filosofos extends  Thread{
	private Palillos Pal;
	private int i;
	private Random r;
	
	public Filosofos(Palillos val, int a) 
	{
		Pal = val;
		i=a;
		r= new Random();
	
	}
	
	public void comiendo(){
		try { // Come con los 2 palillos
			System.out.println("Filosofo comiendo = "+ Integer.valueOf(i));
			sleep(r.nextInt(5000)+1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pensando(){
		try {
			System.out.println("Filosofo Pensando = "+ Integer.valueOf(i));
			sleep(r.nextInt(4000)+1000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true){
			
			Pal.Wait(i); //Pausa en caso de no tener los palillos disponibles
			
			
			this.comiendo();
			
			System.out.println("Filosofo Termino = "+ Integer.valueOf(i));
			
			Pal.Signal(i); // Devuelve los palillos una vez que comio
			
			this.pensando();
			
		
		}
		
		
	}
}
	


