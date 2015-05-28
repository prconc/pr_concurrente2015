package petri;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {

	Procesador_Petri p;
	
	private Lock lock = new ReentrantLock();				//lock para exclusion mutua
	private Condition palillos = lock.newCondition();		//Condicion donde esperan los filosofos.
		
	int [][] disparo1 = new int [][] {{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
	int [][] disparo2 = new int [][] {{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
	Matrix disp1 = new Matrix(disparo1);
	Matrix disp2 = new Matrix(disparo2);

	
	
	public Monitor(int [][] mat, int [][] vec){
		p = new Procesador_Petri (mat, vec);
		
		
	}
	
	public void comer(int quienSoy) throws InterruptedException
	{
		lock.lock();
		disp1.setDato(0,quienSoy,1);
		
		try{
			while(!p.disparar(disp1)){
				disp1.setDato(0,quienSoy,0);
				System.out.println("Filosofo" + quienSoy +" esperando");
				palillos.await();
				disp1.setDato(0,quienSoy,1);
				System.out.println("Filosofo" + quienSoy +" se despierta");
			}
			System.out.println("Filosofo" + quienSoy +" disparo exitoso");
			System.out.println(p.getMarcado().toString());
			disp1.setDato(0,quienSoy,0);
		}
		finally{
			System.out.println("Filosofo" + quienSoy +" comiendo");
			lock.unlock();
		}
	}
	
	
		
	public void devolver_palillos(int quienSoy) throws InterruptedException
	{
		lock.lock();
		disp2.setDato(0,quienSoy+5,1);
		try{
			System.out.println("Filosofo" + quienSoy +" devolviendo palillos");
			p.disparar(disp2);
			System.out.println(p.getMarcado().toString());
			disp2.setDato(0,quienSoy+5,0);
			palillos.signal();
			
		}finally{
			System.out.println("Filosofo" + quienSoy +" devolvio palillos");
			lock.unlock();
		}
		
	}
}
