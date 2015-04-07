
public class Main {

	public static void main(String[] args) {
		
		Contador contador = new Contador(4);
		
		Palillo p1 = new Palillo();
		Palillo p2 = new Palillo();
		Palillo p3 = new Palillo();
		Palillo p4 = new Palillo();
		Palillo p5 = new Palillo();
		
		Filosofo filosofo1 = new Filosofo("Platón", p1, p2, contador);
		Filosofo filosofo2 = new Filosofo("Konfuzius", p2, p3, contador);
		Filosofo filosofo3 = new Filosofo("Sócrates", p3, p4, contador);
		Filosofo filosofo4 = new Filosofo("Voltaire", p4, p5, contador);
		Filosofo filosofo5 = new Filosofo("Descartes", p5, p1, contador);
		
		Thread f1 = new Thread(filosofo1);
		Thread f2 = new Thread(filosofo2);
		Thread f3 = new Thread(filosofo3);
		Thread f4 = new Thread(filosofo4);
		Thread f5 = new Thread(filosofo5);
		
		f1.start();
		f2.start();
		f3.start();
		f4.start();
		f5.start();
	}
}
