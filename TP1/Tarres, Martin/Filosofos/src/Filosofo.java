import java.util.Random;
public class Filosofo implements Runnable{
Palillo palilloderecho;
Palillo palilloizquierdo;
Contador contador;
int numerofilosofo;
int cantoperaciones;

public Filosofo(int numerofilosofo, Palillo palilloderecho, Palillo palilloizquierdo, Contador contador){
	this.palilloderecho=palilloderecho;
	this.palilloizquierdo=palilloizquierdo;
	this.contador=contador;
	this.numerofilosofo=numerofilosofo;
}
public void pensando(){
		try{
			System.out.println("Filosofo "+ numerofilosofo+ " pensando");
			wait();
			} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
										}
					}

public void run(){
	while(true){
		System.out.println("Filosofo "+ numerofilosofo+ " esperando para comer");
		contador.incrementa();
																 
		palilloderecho.agarrar();
		palilloizquierdo.agarrar();
		System.out.println("Filosofo "+ numerofilosofo+ " comiendo");
			try {
				Random rand = new Random();
				Thread.sleep(rand.nextInt(2000));
				} 
			catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
											}
			palilloderecho.soltar();
			palilloizquierdo.soltar();
			contador.decrece();
			cantoperaciones++;
		
		System.out.println("Filosofo "+ numerofilosofo+ " ha terminado de comer "+ cantoperaciones+ " veces");
			try {
				Random rand = new Random();
				Thread.sleep(rand.nextInt(3000));
				
				} 		
			 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
								}								
				  
					}
					}
												}
											
		
	
		

