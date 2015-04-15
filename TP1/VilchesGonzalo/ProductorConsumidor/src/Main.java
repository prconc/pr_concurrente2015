public class Main {

	public static void main(String[] args) {
		
		Semaforo lleno=new Semaforo(0);
		Semaforo vacio=new Semaforo(10);
		Semaforo mutex=new Semaforo(1);
		variable vari = new variable(10,0,5);
		Productor productor1 = new Productor(vari,lleno,vacio,mutex,1);
		Productor productor2 = new Productor(vari,lleno,vacio,mutex,2);
		Consumidor consumidor1 = new Consumidor(vari,lleno,vacio,mutex,1);
		Consumidor consumidor2 = new Consumidor(vari,lleno,vacio,mutex,2);
        Thread hilo1= new Thread(productor1);
        Thread hilo3= new Thread(productor2);
        Thread hilo2= new Thread(consumidor1);
        Thread hilo4= new Thread(consumidor2);
        hilo2.start();
        hilo1.start();
        hilo4.start();
        hilo3.start();
        
	}

}
