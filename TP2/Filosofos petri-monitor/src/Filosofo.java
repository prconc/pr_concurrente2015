public class Filosofo implements Runnable {
	Matrix disparo1, disparo2;
	Monitor monitor;
	int id;
	
	public Filosofo(Monitor monitor, Matrix disparo1, Matrix disparo2, int id){
		this.monitor = monitor;
		this.id = id;
		this.disparo1 = disparo1;
		this.disparo2 = disparo2;
	}
	
	public void run(){
		while(true){
			System.out.println("Filosofo "+id+" quiere comer");
			monitor.comer(disparo1, id);
			try{
				Thread.sleep((int)Math.random()*1000 + 500);
			} catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("Filosofo "+id+" deja de comer");
			monitor.dejarDeComer(disparo2,id);
		}
	}
}
