import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



//la clase Monitor contiene la red de petri, el lock y la condicion palillos.
//los vectores comiendo y durmiendo se van actualizando y estan solo para fines
//de comprobar funcionamiento. se imprimin cada vez que un trhead ejecuta algun
//metodo del monitor para checkear el estado del mismo y si cumple con las
//condiciones de sincronizacion.
//
//En la consola, cada bloque encerrado entre "----------------------------"
//indica un thread que contiene el lock del monitor y esta ejecutando metodos
//del mismo.

public class Monitor {
	
	
	
	ProcesadorPetri petriNet; //red de petri del monitor
	private Lock lock = new ReentrantLock(); //lock de exclusion mutua.
	private	Condition palillos = lock.newCondition(); // variable de condicion.
	int [] comiendo = {0,0,0,0,0};
	int [] durmiendo = {0,0,0,0,0};
	
	
	
	public Monitor(Matrix incidencia, Matrix marcaInicial)
	{
		petriNet = new ProcesadorPetri(incidencia, marcaInicial);
	}
	
	public void comer(Matrix disparo, int id){
		lock.lock();	//se obtiene la exclusion mutua
		System.out.println("-----------------------------------------------------");
		System.out.println("filosofo "+id +" quiere comer");
		
		try {
			while(!petriNet.disparar(disparo)){ //se cheque si el disparo es realizable
				try {
					System.out.println("filosofo "+id +" se duerme se duerme");
					durmiendo[id] = 1; 
					imprimirEstado();
					System.out.println("-----------------------------------------------------\n");
					palillos.await();  //filosofo se duerme en la cola de la variable de condicion.
					durmiendo[id] = 0;
					System.out.println("-----------------------------------------------------");
					System.out.println("filosofo "+id +" se despierta");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		finally{
			comiendo[id] = 1;
			imprimirEstado();
			//petriNet.imprimirMarcado();
			System.out.println("filoso "+id+" empezo a comer");
			System.out.println("-----------------------------------------------------\n");
			
			lock.unlock(); // se librea la exclusion mutua
		}
	}
	
	
	
	public void devolverPalillo(Matrix disparo,int id){
		lock.lock();   // se obtiene la exclusion mutua
		System.out.println("-----------------------------------------------------");
		System.out.println("filosofo "+id +" quiere devolver palillos");
		
		try{
			petriNet.disparar(disparo); //se dispara la transicion que se asume posible
			comiendo[id] = 0;
			//petriNet.imprimirMarcado();
			palillos.signal();   //se despierta algun filosofo si es que hay alguno esperando
		}
		
		finally{
			imprimirEstado();
			System.out.println("filoso "+id+" solto palillos");
			System.out.println("-----------------------------------------------------\n");
			
			lock.unlock(); // se libera la exclusion mutua
		}
	}
	
	
	
	
	// funciones de uso interno solo para verificar funcionamiento.
	
	
	private void imprimirEstado(){
		System.out.println("comiendo: ");
		printVector(comiendo);
		System.out.println("durmiendo:");
		printVector(durmiendo);
	}
	private void printVector(int [] vector){
		for (int i = 0; i < vector.length; i++){
			System.out.print(vector[i]+ " ");
		}
		System.out.println();
	}

}







