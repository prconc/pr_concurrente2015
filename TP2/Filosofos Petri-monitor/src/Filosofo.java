import java.util.Random;
public class Filosofo implements Runnable {

	Matrix Disparo1;
	Matrix Disparo2;
	Monitor Monitor;
	int id;
	Random rnd = new Random();

	public Filosofo(Monitor m,int id,Matrix d1,Matrix d2)
	{
		this.id=id;
		Disparo1=d1;
		Disparo2=d2;
		Monitor=m;
	}

	public void run() {
		while(true){
			System.out.println("Filosofo "+ id+" quiere comer.");
			Monitor.comer(Disparo1,id);
			try {
				Thread.sleep((int)(Math.random()*1000 + 500));
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Filosofo "+ id+" quiere devolver palillos.");
			Monitor.Soltar(Disparo2,id);
		}
	}
}
