
public class Main {

	public static void main(String[] args) {
		Semaforo sesc=new Semaforo(1);        
		Semaforo slec=new Semaforo(2);        
		Escritor esc1=new Escritor(1,slec);
		Lector lec1=new Lector(1,sesc,slec);
		Lector lec2=new Lector(2,sesc,slec);
		Lector lec3=new Lector(3,sesc,slec);
		Thread hilo1= new Thread(esc1);
        Thread hilo2= new Thread(lec1);
        Thread hilo3= new Thread(lec2);
        Thread hilo4= new Thread(lec3);
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
	}

}
