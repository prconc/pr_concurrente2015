

public class Main {

	
  
    /**
     * ---------------------------------------------
     * | Lectores y escritores con buffer Circular |
     * ---------------------------------------------
     * Existe un buffer cuyo tamaño es finito, un conjunto de hilos que
     * intentan leer datos del buffer y un conjunto de hilos que intentan
     * escribir datos en el buffer.
     *
     * La lectura implica que el dato  NO es removido del buffer. No se puede
     * realizar una lectura si el buffer esta vacio. Quien intente leer debe
     * esperar en caso de que no haya datos.Dos Lectores Pueden leer al mismo Tiempo 
     *
     * La escritura implica ingresar un dato en el buffer . EL buffer es circular
     * por lo que si  esta lleno se vuelve al indice 0 del mismo y se sobreescriben los datos.
     * Quien intenta escribir debe esperar si hay un Lector relizando un tarea.
     *
     */
	
	
	
	
	public static void main(String[] args) {
	
		Buffer b = new Buffer(30);
		
		//Creo 5 Hilos Escritores
		
		for (int idp = 1 ; idp<=7;idp++){ 
			
			 new Thread (new Escritor(idp,b)).start();
			
			 	}
			
		//Creo 7 hilos Lectores
		for (int idc = 1 ; idc<=5;idc++){
			
			 new Thread (new Lector(idc,b)).start();
	   }
		
	}

}
