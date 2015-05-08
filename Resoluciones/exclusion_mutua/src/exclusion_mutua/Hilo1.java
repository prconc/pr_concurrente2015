package exclusion_mutua;

import java.util.Arrays;

public class Hilo1 implements Runnable{
	
	int [] disparo0 = new int [] { 1, 0, 0, 0};
	int [] disparo1 = new int [] { 0, 1, 0, 0};

	
	private Red_petri red_petri;
	private String name;
	
	private boolean disparo= false;
	private int cantidad_disparos = 2;
	
	//private final Lock lock = new ReentrantLock();
	
	public Hilo1(Red_petri red_petri, String name) {
		// TODO Auto-generated constructor stub
		this.red_petri = red_petri;
		this.setName(name);
	}


	@Override
	public void run() {
		
		// Ejecucion hilo 1.
		System.out.println("Ejecucion hilo 1");
		
		for (int i=0; i<cantidad_disparos;i++){
			// Solicitud disparo 0 y 1.
			this.red_petri.imprimir_marcado();
			
			disparo = this.red_petri.disparar(disparo0);
			
			if (disparo==true){
				this.red_petri.imprimir_marcado();
				disparo = this.red_petri.disparar(disparo1);
				
				System.out.println("Se ha disparado 0 y 1");
			}
			else {
				System.out.println("No se puede disparar " + Arrays.toString(this.disparo0) );
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
