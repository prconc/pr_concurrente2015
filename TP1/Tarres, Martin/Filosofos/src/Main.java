
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub}
		
										 
	
	Contador contador= new Contador (4);
	
	

		for(int i=0; i<5; i++){
			
			
			Palillo p1 = new Palillo();
			Palillo p2 = new Palillo();
			Palillo p3 = new Palillo();
			Palillo p4 = new Palillo();
			Palillo p5 = new Palillo();
			
			Filosofo filosofo1 = new Filosofo(i ,p1, p2 , contador);
			Filosofo filosofo2 = new Filosofo(i, p2, p3, contador);
			Filosofo filosofo3 = new Filosofo(i, p3, p4, contador);
			Filosofo filosofo4 = new Filosofo(i, p4, p5, contador);
			Filosofo filosofo5 = new Filosofo(i, p5, p1, contador);
			
			Thread H1 = new Thread(filosofo1);
			Thread H2 = new Thread(filosofo2);
			Thread H3 = new Thread(filosofo3);
			Thread H4 = new Thread(filosofo4);
			Thread H5 = new Thread(filosofo5);
			
			H1.start();
			H2.start();
			H3.start();
			H4.start();
			H5.start();
								}
												}
					}

			
			