
public class Salvaje extends Thread{

	MonitorInterface olla;

	public Salvaje(MonitorInterface olla) {
		super();
		this.olla = olla;
	}	

	public void run(){
		for(int i= 1; i<= 5; i++){
			try {
				olla.sacarMisionero();
				//En este punto el salvaje obtuvo el recurso (misionero) 
				//Esta fuera del monitor y hace lo que necesite con el.
				//Es comun modelar con tiempos muertos con sleeps. 
				
				System.out.println("El salvaje "+this.getName() + " comio "+i+"veces");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
