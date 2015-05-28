
public class Main {
public static void main(String[] args){
	Monitor monitor=new Monitor();
	
	//creo todos los disparos como una matriz de 10 filas y 1 columna
	Matrix Disp1Fil0=new Matrix (10,1);
	Matrix Disp2Fil0=new Matrix (10,1);
	Matrix Disp1Fil1=new Matrix (10,1);
	Matrix Disp2Fil1=new Matrix (10,1);
	Matrix Disp1Fil2=new Matrix (10,1);
	Matrix Disp2Fil2=new Matrix (10,1);
	Matrix Disp1Fil3=new Matrix (10,1);
	Matrix Disp2Fil3=new Matrix (10,1);
	Matrix Disp1Fil4=new Matrix (10,1);
	Matrix Disp2Fil4=new Matrix (10,1);
	//cargo todos los elementos de los disparos con 0
	for(int i=0;i<10;i++){
		Disp1Fil0.setDato(i,0 , 0);
		Disp2Fil0.setDato(i,0 , 0);
	}
	for(int i=0;i<10;i++){
		Disp1Fil1.setDato(i,0 , 0);
		Disp2Fil1.setDato(i,0 , 0);
	}
	for(int i=0;i<10;i++){
		Disp1Fil2.setDato(i,0 , 0);
		Disp2Fil2.setDato(i,0 , 0);
	}
	for(int i=0;i<10;i++){
		Disp1Fil3.setDato(i,0 , 0);
		Disp2Fil3.setDato(i,0 , 0);
	}
	for(int i=0;i<10;i++){
		Disp1Fil4.setDato(i,0 , 0);
		Disp2Fil4.setDato(i,0 , 0);
	}
	//cargo el disparo correspondiente dependiendo del filosofo
	Disp1Fil0.setDato(0, 0, 1);
	Disp2Fil0.setDato(5, 0, 1);
	Disp1Fil1.setDato(1, 0, 1);
	Disp2Fil1.setDato(6, 0, 1);
	Disp1Fil2.setDato(2, 0, 1);
	Disp2Fil2.setDato(7, 0, 1);
	Disp1Fil3.setDato(3, 0, 1);
	Disp2Fil3.setDato(8, 0, 1);
	Disp1Fil4.setDato(4, 0, 1);
	Disp2Fil4.setDato(9, 0, 1);
	
	//creo los 5 filosofos
	Filosofo f0= new Filosofo(monitor,0,Disp1Fil0,Disp2Fil0);
	Thread t0=new Thread(f0);
	t0.start();
	Filosofo f1= new Filosofo(monitor,1,Disp1Fil1,Disp2Fil1);
	Thread t1=new Thread(f1);
	t1.start();
	Filosofo f2= new Filosofo(monitor,2,Disp1Fil2,Disp2Fil2);
	Thread t2=new Thread(f2);
	t2.start();
	Filosofo f3= new Filosofo(monitor,3,Disp1Fil3,Disp2Fil3);
	Thread t3=new Thread(f3);
	t3.start();
	Filosofo f4= new Filosofo(monitor,4,Disp1Fil4,Disp2Fil4);
	Thread t4=new Thread(f4);
	t4.start();
}
}
