

public class Main {

	public static void main(String[] args) {
		
		int [][] Mat_I = {
	 			 {-1, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, 
	 			 { 0,-1, 0, 0, 0, 0, 1, 0, 0, 0 }, 
	 			 { 0, 0,-1, 0, 0, 0, 0, 1, 0, 0 },
	 		   	 { 0, 0, 0,-1, 0, 0, 0, 0, 1, 0 },
	 		   	 { 0, 0, 0, 0,-1, 0, 0, 0, 0, 1 },
	 		   	 { 1, 1, 0, 0, 0,-1,-1, 0, 0, 0 },
	 		   	 { 0, 1, 1, 0, 0, 0,-1,-1, 0, 0 },
	 		   	 { 0, 0, 1, 1, 0, 0, 0,-1,-1, 0 },
	 		   	 { 0, 0, 0, 1, 1, 0, 0, 0,-1,-1 },
	 		   	 { 1, 0, 0, 0, 1,-1, 0, 0, 0,-1 },
	 		   	 }; 
		
		
		int []marcado = { 0 , 0 , 0 , 0 , 0 ,  1 , 1 , 1 , 1 , 1 }; 
			
		Procesador_Petri red_pet=new Procesador_Petri(Mat_I, marcado);
		Palillos buf=new Palillos();
		Monitor mon=new Monitor(buf, red_pet);
		
		int[] disparo00 = { 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 };
		int[] disparo10 = { 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 };
		int[] disparo20 = { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 };
		int[] disparo30 = { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 };
		int[] disparo40 = { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 };
		int[] disparo01 = { 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 };
		int[] disparo11 = { 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 };
		int[] disparo21 = { 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 };
		int[] disparo31 = { 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 };
		int[] disparo41 = { 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 };
		
		Filosofos []c =new Filosofos[5];
		c[0]=new Filosofos(0,mon,disparo00,disparo01);
		c[1]=new Filosofos(1,mon,disparo10,disparo11);
		c[2]=new Filosofos(2,mon,disparo20,disparo21);
		c[3]=new Filosofos(3,mon,disparo30,disparo31);
		c[4]=new Filosofos(4,mon,disparo40,disparo41);
		

		
		c[0].start();
		c[1].start();
		c[2].start();
		c[3].start();
		c[4].start();
		
		/*
		Productor p1 = new Productor(1,mon);
		Productor p2 = new Productor(2,mon);
		Productor p3 = new Productor(3,mon);
		Productor p4 = new Productor(4,mon);
		
		
		Consumidor c1 = new Consumidor(1,mon);
		Consumidor c2 = new Consumidor(2,mon);

		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		
		c1.start();
		c2.start();
*/
	}
}
	
