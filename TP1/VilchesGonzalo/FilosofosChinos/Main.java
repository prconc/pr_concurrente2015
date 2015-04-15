
public class Main {

	public static void main(String[] args) {
		
		int a[]={1,1,1,1,1};
		Palillos Palillos1=new Palillos();
		Filosofos Filosofo1 = new Filosofos(Palillos1,1);
		Filosofos Filosofo2 = new Filosofos(Palillos1,2);
		Filosofos Filosofo3 = new Filosofos(Palillos1,3);
		Filosofos Filosofo4 = new Filosofos(Palillos1,4);
		Filosofos Filosofo5 = new Filosofos(Palillos1,5);
		
		Filosofo1.start();
		Filosofo2.start();
		Filosofo3.start();
		Filosofo4.start();
		Filosofo5.start();
		
		

	}

}
