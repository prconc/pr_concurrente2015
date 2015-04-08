



public class Main {

    /**
     * ------------------------------------------------
     * | Productores y Consumidores con buffer finito |
     * ------------------------------------------------
     * Existe un buffer cuyo tamaño es finito, un conjunto de hilos que
     * intentan leer datos del buffer y un conjunto de hilos que intentan
     * escribir datos en el buffer.
     *
     * El consumir un dato implica que el dato  es removido del buffer. No se puede
     * realizar una consumo si el buffer esta vacio. Quien intente consumir debe
     * esperar en caso de que no haya datos. 
     *
     * La Produccion implica ingresar un dato en el buffer . EL buffer es finito
     * por lo que si  esta lleno  el productor debe esperar hasta que se consuman datos.
     * 
     * No se puede producir mientras se esta consumiendo ni se puede consumir mientras se esta produciendo
     *  
     */
	
	
	
	


	public static void main(String[] args) {
	
		
	Buffer b = new Buffer(60);
		
	//Creo 5 Hilos productores 
		
	for (int idp = 1 ; idp<=5;idp++){ 
		
		 new Thread (new Productor(idp,b)).start();
		
		 
		
		}
		
	//Creo 7 hilos consumidores
	for (int idc = 1 ; idc<=7;idc++){
		
		 new Thread (new Consumidor(idc,b)).start();
   }

}
}
