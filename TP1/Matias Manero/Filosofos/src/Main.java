
public class Main {


		public static void main(String[] args) { 
			
		Mesa cena=new Mesa();
		
		
		Filosofo p1 = new Filosofo(0, cena);

		Filosofo p2 = new Filosofo(1, cena);

		Filosofo p3 = new Filosofo(2, cena);

		Filosofo p4 = new Filosofo(3, cena);

		Filosofo p5 = new Filosofo(4, cena);
		

		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		}
	}
