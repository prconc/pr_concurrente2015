
import java.util.Random;


public class Buffer {

	int cantLectores=0;           // Cantidad de Lectores  accediendo al Buffer
	boolean hayEscritor= false;   // Defino en true si hay un escritor en el buffer 
	boolean isnull =true;        // variable para identificar si hay algo escrito en el buufer (sirve cuando se incia el programa por si quiere leer antes de que alla escrito algo)
	
	
    private Integer[] buf;     // Pila de tamaño finito del contenedor.
    private int indice=0;     // Indicador de la ultima posicion en la cual se escribio un dato.
	
 
    
    public  Buffer (int capacidad){
             
    	 buf  = new Integer[capacidad];
    
    }
	

	
	
    //Este metodo no esta sincronizado para permitir la concurrencia  de Lectores 
    
    public  void leerDato(int i ) {
   
        //Protocolo de Entrada
     	
    	
    	synchronized  (this) {
    	
    		
 	// si hay escritor o si no hay dato ESPERA
    	
    		while (hayEscritor || isnull)   {
    	
    		 try {
                 this.wait();        
             } catch (InterruptedException e) {
             	e.printStackTrace();
             }
    	}
    	
    	cantLectores++; //Acumula la cantidad de lectores 
    	
    
    	}
    	
    	
    	//Leyendo sin  sincronizar para permitir 2 o mas lectores Acceder  al buffer al mismo tiempo 
    	
    	
    	
     	int dato = (int)(new Random().nextDouble() * buf.length); // genero un indice Aleatorio para leer De cualquier posicion (El rango  depende  del indice maximo actual )
    	
    	
    	System.out.println(" Lector " + i + " leyo dato = " + buf[dato] +" Valor del indice "+ dato);
    	
    	
    	//Protocolo de salida
    	
    	
    	synchronized (this){
    		
    		cantLectores --;
    		
    		if (cantLectores==0) notifyAll();
    	}
         
    
    }
			
	
	
	
    public synchronized void escribirDato(int id,Integer dato){
      
        
    	//Entrada
    	
    	synchronized (this){
    		
    		/*Pongo como condicion que ademas de  que no se este escribiendo  no tenga lenctores esperando,
    		*puedo poner un criterio  por ej:que no alla mas de 3 lectores esperando
    		*/
    		while (hayEscritor || (cantLectores>0)) 
				try {
					wait();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
    	
    	hayEscritor=true;
    	}
    	
    	
    	
    	//Escribo dato 
    	
    	buf[indice]=dato;
    	
    	System.out.println("Escritor "+ id + " escribio dato = " + dato + " en indice : "+indice);
    	
    	// si llene la capacidad  vuelvo al indice 0  (Buffer circular) 
    	if (indice == buf.length-1)
    	indice=0;
    	else	
        indice++;
         
    	//Salida 
    	
    	
    	synchronized (this){
    	hayEscritor=false;
    	isnull=false;
    	this.notifyAll(); 
    	}
      
                     
    
        
        
        }
	
	
    }


