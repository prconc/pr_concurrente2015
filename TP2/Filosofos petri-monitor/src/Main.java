public class Main {
	public static void main(String[] args){
		
		int [][] incidence = 	{
				{ 1,0,0,0,0,-1,0,0,0,0 },
				{ 0,1,0,0,0,0,-1,0,0,0 },
				{ 0,0,1,0,0,0,0,-1,0,0 },
				{ 0,0,0,1,0,0,0,0,-1,0 },
				{ 0,0,0,0,1,0,0,0,0,-1 },
				{ -1,0,0,0,0,1,0,0,0,0 },
				{ 0,-1,0,0,0,0,1,0,0,0 },
				{ 0,0,-1,0,0,0,0,1,0,0 },
				{ 0,0,0,-1,0,0,0,0,1,0 },
				{ 0,0,0,0,-1,0,0,0,0,1 },
				{ 0,0,0,-1,-1,0,0,0,1,1 },
				{ -1,0,0,0,-1,1,0,0,0,1 },
				{ -1,-1,0,0,0,1,1,0,0,0 },
				{ 0,-1,-1,0,0,0,1,1,0,0 },
				{ 0,0,-1,-1,0,0,0,1,1,0 },
			};
		
		int [][] marking =  { {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1} };
		
		Monitor monitor = new Monitor(incidence, marking);
		
		Matrix disp1Fil0 = new Matrix(10,1);
		Matrix disp2Fil0 = new Matrix(10,1);
		Matrix disp1Fil1 = new Matrix(10,1);
		Matrix disp2Fil1 = new Matrix(10,1);
		Matrix disp1Fil2 = new Matrix(10,1);
		Matrix disp2Fil2 = new Matrix(10,1);
		Matrix disp1Fil3 = new Matrix(10,1);
		Matrix disp2Fil3 = new Matrix(10,1);
		Matrix disp1Fil4 = new Matrix(10,1);
		Matrix disp2Fil4 = new Matrix(10,1);
		
		for(int i=0; i<10; i++){
			disp1Fil0.setDato(i,0,0);
			disp2Fil0.setDato(i,0,0);
			disp1Fil1.setDato(i,0,0);
			disp2Fil1.setDato(i,0,0);
			disp1Fil2.setDato(i,0,0);
			disp2Fil2.setDato(i,0,0);
			disp1Fil3.setDato(i,0,0);
			disp2Fil3.setDato(i,0,0);
			disp1Fil4.setDato(i,0,0);
			disp2Fil4.setDato(i,0,0);
		}
		
		disp1Fil0.setDato(0,0,1);
		disp2Fil0.setDato(5,0,1);
		disp1Fil1.setDato(1,0,1);
		disp2Fil1.setDato(6,0,1);
		disp1Fil2.setDato(2,0,1);
		disp2Fil2.setDato(7,0,1);
		disp1Fil3.setDato(3,0,1);
		disp2Fil3.setDato(8,0,1);
		disp1Fil4.setDato(4,0,1);
		disp2Fil4.setDato(9,0,1);
		
		
		
		Filosofo filosofo0 = new Filosofo(monitor, disp1Fil0, disp2Fil0,0);
		Thread thread0 = new Thread(filosofo0);
		thread0.start();
		
		Filosofo filosofo1 = new Filosofo(monitor, disp1Fil1, disp2Fil1,1);
		Thread thread1 = new Thread(filosofo1);
		thread1.start();
		
		Filosofo filosofo2 = new Filosofo(monitor, disp1Fil2, disp2Fil2,2);
		Thread thread2 = new Thread(filosofo2);
		thread2.start();
		
		Filosofo filosofo3 = new Filosofo(monitor, disp1Fil3, disp2Fil3,3);
		Thread thread3 = new Thread(filosofo3);
		thread3.start();
		
		Filosofo filosofo4 = new Filosofo(monitor, disp1Fil4, disp2Fil4,4);
		Thread thread4 = new Thread(filosofo4);
		thread4.start();

	}
}
