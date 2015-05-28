import java.util.logging.Level;
import java.util.logging.Logger;


public class MainLectorEscritor {

	public static int cantidad_recursos = 5;
	public static int num_lectores = 3;
	public static int num_escritores = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Recurso recurso = new Recurso();
		
		for (int i=0; i<num_lectores; i++){
			Lector L = new Lector(recurso, i);//.start();
			Thread hL = new Thread(L); 
			hL.start();
		}
		for (int j=0; j<num_escritores; j++){
			Escritor E = new Escritor(recurso, j);//;.start();
			Thread hE = new Thread(E); 
			hE.start();
		}

		 try { Thread.sleep(4000); }  // Espera para que todos los hilos accedan a la pila del contenedor.
	        catch (InterruptedException ex) { Logger.getLogger(MainLectorEscritor.class.getName()).log(Level.SEVERE, null, ex); }
		 
		 System.out.println("Fin Lector Escritor");

	}

}
