package exclusion_mutua;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Crear objetos necesarios.
		Red_petri red_petri = new Red_petri();
	
		Hilo1 h1=new Hilo1(red_petri, "hilo1");
		Hilo2 h2=new Hilo2(red_petri, "hilo2");
		
		Thread hilo1 = new Thread(h1);
		Thread hilo2 = new Thread(h2);
		
		hilo1.start();
		hilo2.start();
		
		try { Thread.sleep(4000); }  // Espera para que todos los hilos accedan a la pila del contenedor.
        catch (InterruptedException ex) { Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex); }
		
		System.out.println("Fin Exclusion Mutua");
		red_petri.imprimir_marcado();

	}

}
