
public class Main {

	public static void main(String[] args){
	Semaforo n1=new Semaforo(0);
	Semaforo n2=new Semaforo(10);
	
	Buffer buffer=new Buffer();
	
	Productor p1=new Productor(n1,n2,buffer);
	Productor p2=new Productor(n1,n2,buffer);
	Productor p3=new Productor(n1,n2,buffer);
	
	Consumidor c1=new Consumidor(n1,n2,buffer);
	Consumidor c2=new Consumidor(n1,n2,buffer);
	Consumidor c3=new Consumidor(n1,n2,buffer);
	
	Thread hilo1= new Thread(p1);
	Thread hilo2= new Thread(p2);
	Thread hilo3= new Thread(p3);
	Thread hilo4= new Thread(c1);
	Thread hilo5= new Thread(c2);
	Thread hilo6= new Thread(c3);
	

	
	hilo1.start();
	hilo2.start();
	hilo3.start();
	hilo4.start();
	hilo5.start();
	hilo6.start();
	
	
	}
	
}
