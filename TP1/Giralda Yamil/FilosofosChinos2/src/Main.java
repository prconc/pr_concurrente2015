
public class Main {

	public static void main(String[] args) {
		Semaforo palillo1=new Semaforo(1);        
		Semaforo palillo2=new Semaforo(1);
		Semaforo palillo3=new Semaforo(1);
		Semaforo palillo4=new Semaforo(1);
		Semaforo palillo5=new Semaforo(1);
		Semaforo sitio=new Semaforo(4);
		
		Filosofo filosofo1=new Filosofo(1,palillo1,palillo2,sitio);
		Filosofo filosofo2=new Filosofo(2,palillo2,palillo3,sitio);
		Filosofo filosofo3=new Filosofo(3,palillo3,palillo4,sitio);
		Filosofo filosofo4=new Filosofo(4,palillo4,palillo5,sitio);
		Filosofo filosofo5=new Filosofo(5,palillo5,palillo1,sitio);
		
		Thread hilo1= new Thread(filosofo1);
        Thread hilo2= new Thread(filosofo2);
        Thread hilo3= new Thread(filosofo3);
        Thread hilo4= new Thread(filosofo4);
        Thread hilo5= new Thread(filosofo5);
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
	}

}