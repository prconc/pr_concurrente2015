public class Main {
public static void main(String args[]){
	int a=8;
	Recurso recurso=new Recurso(a);
	//for(int i=0;i<5;i++)
	Lector L0=new Lector(recurso,0);
	Lector L1=new Lector(recurso,1);
	Lector L2=new Lector(recurso,2);
	Thread t0=new Thread(L0);
	Thread t1=new Thread(L1);
	Thread t2=new Thread(L2);
	t0.start();
	t1.start();
	t2.start();
	//for(int j=0;j<5;j++)
	Escritor E0=new Escritor(recurso,0,9);
	Thread t3=new Thread(E0);
	t3.start();

	Lector L3=new Lector(recurso,3);
	Lector L4=new Lector(recurso,4);
	Thread t4=new Thread(L3);
	Thread t5=new Thread(L4);
	t4.start();
	t5.start();
}
}
