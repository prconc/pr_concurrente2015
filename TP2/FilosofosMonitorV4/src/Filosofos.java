
public class Filosofos extends Thread {
	private int nom;
	private Monitor monitor;
	private int[] disparo1;
	private int[] disparo2;
	private int cont=0;
	
	public Filosofos(int id, Monitor monitor, int[] disparo1 , int[] disparo2 )
	{
		nom=id;
		this.monitor=monitor;
		this.disparo1=disparo1;
		this.disparo2=disparo2;
	}
	
	public void run(){
		while(true){
			monitor.comiendo(nom,disparo1);
			try {
				sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			monitor.devolver(nom,disparo2);
			
			cont++;
			
			System.out.println("Filosofo: " + nom + "Comio:" + cont + " veces "); 
			
			
			monitor.pensando(nom);
			/*try {
				sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			// System.out.println("Filosofo; " + nom +" Le agarro hambre."); 
			  
		}
	}
}