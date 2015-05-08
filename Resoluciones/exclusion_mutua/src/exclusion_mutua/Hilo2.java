package exclusion_mutua;

import java.util.Arrays;


public class Hilo2 implements Runnable{
	
	int [] disparo2 = new int [] { 0, 0, 1, 0};
	int [] disparo3 = new int [] { 0, 0, 0, 1};
	
	private Red_petri red_petri;
	private String name;
	
	private boolean disparo= false;
	private int cantidad_disparos = 2;
	
	//private final Lock lock = new ReentrantLock();
	
	public Hilo2(Red_petri red_petri, String name) {
		// TODO Auto-generated constructor stub
		this.red_petri = red_petri;
		this.setName(name);
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Ejecucion hilo 2");
		
		for (int i=0; i<cantidad_disparos;i++){
			// Solicitud disparo 2 y 3.	
			this.red_petri.imprimir_marcado();
			
			disparo = this.red_petri.disparar(disparo2);
				
			if (disparo==true){
				this.red_petri.imprimir_marcado();
				disparo = this.red_petri.disparar(disparo3);
				
				System.out.println("Se ha disparado 2 y 3");
			}
			else {
				System.out.println("No se puede disparar " + Arrays.toString(this.disparo2) );
			}
		}
		
		
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
