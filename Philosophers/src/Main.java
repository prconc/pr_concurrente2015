public class Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		int [][] MI = {
						{ -1,  0,  0,  0, -1,  1,  0,  0,  0,  1},
						{ -1, -1,  0,  0,  0,  1,  1,  0,  0,  0},
						{  1,  0,  0,  0,  0, -1,  0,  0,  0,  0},
						{  0,  1,  0,  0,  0,  0, -1,  0,  0,  0},
						{  0,  0,  1,  0,  0,  0,  0, -1,  0,  0},
						{  0,  0,  0,  1,  0,  0,  0,  0, -1,  0},
						{  0,  0,  0,  0,  1,  0,  0,  0,  0, -1},
						{  0, -1, -1,  0,  0,  0,  0,  1,  1,  0},
						{  0,  0, -1, -1,  0,  0,  0,  0,  1,  1},
						{  0,  0,  0, -1, -1,  0,  0,  0,  1,  1},
						{ -1,  0,  0,  0,  0,  1,  0,  0,  0,  0},
						{  0, -1,  0,  0,  0,  0,  1,  0,  0,  0},
						{  0,  0, -1,  0,  0,  0,  0,  1,  0,  0},
						{  0,  0,  0, -1,  0,  0,  0,  0,  1,  0},
						{  0,  0,  0,  0, -1,  0,  0,  0,  0,  1},
	 		   	 };

		int [] marcado = { 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 };
		
		ProcesadorPetri ppetri = new ProcesadorPetri(MI, marcado);
		
		MonitorInterface mon = new Monitor2(ppetri);
		
		int [] dc1 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int [] dc2 = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
		int [] dc3 = {0, 0, 1, 0, 0, 0, 0, 0, 0, 0};
		int [] dc4 = {0, 0, 0, 1, 0, 0, 0, 0, 0, 0};
		int [] dc5 = {0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
		
		int [] dt1 = {0, 0, 0, 0, 0, 1, 0, 0, 0, 0};
		int [] dt2 = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
		int [] dt3 = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
		int [] dt4 = {0, 0, 0, 0, 0, 0, 0, 0, 1, 0};
		int [] dt5 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
		
		Filosofo fil1 = new Filosofo(mon, dc1, dt1,1);
		Filosofo fil2 = new Filosofo(mon, dc2, dt2,2);
		Filosofo fil3 = new Filosofo(mon, dc3, dt3,3);
		Filosofo fil4 = new Filosofo(mon, dc4, dt4,4);
		Filosofo fil5 = new Filosofo(mon, dc5, dt5,5);
		
		fil1.start();
		fil2.start();
		fil3.start();
		fil4.start();
		fil5.start();
		
	}

}
