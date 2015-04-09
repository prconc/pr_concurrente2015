
public class Filosofo implements Runnable
{
private Contador contador;
private Palillo palilloder, palilloizq;
private int numerodeoperaciones=10;
private int quiensoy;
	
	
	
public Filosofo(int quiensoy, Contador contador, Palillo palilloder, Palillo palilloizq )
{
this.quiensoy= quiensoy;
this.contador= contador;
this.palilloder = palilloder;
this.palilloizq = palilloizq;
}


public void run()
{
	  
	for(int i=0; i<numerodeoperaciones; i++)
           { 
              System.out.println("El filosofo "+ quiensoy +" esta pensando");

              contador.incrementarcontador();
              palilloder.agarrar(quiensoy);
              palilloizq.agarrar(quiensoy);

              System.out.println("El filosofo "+ quiensoy + " esta comiendo con los palillos "+ palilloder.getindice()+" y "+palilloizq.getindice());
              //tiempo que tarda el filosofo en comer.
              try{Thread.sleep(100);}                            
              catch(InterruptedException c){c.printStackTrace();}
              
              System.out.println("El filosofo "+ quiensoy + " termino de comer");
              palilloder.soltar();
              palilloizq.soltar();
              contador.decrementarcontador();
              
             //tiempo que tarda el filosofo para que pueda volver a pensar.
              try{Thread.sleep(100);}                            
              catch(InterruptedException c){c.printStackTrace();}
             }
}

}
