
public class Filosofo implements Runnable{
int n_filosofo;
Palillo palizq, palder;
Contador cont;
int operaciones = 10;	
	Filosofo(int n_filosofo,Palillo palizq,Palillo palder,Contador cont){
		this.n_filosofo = n_filosofo;
		this.palizq = palizq;
		this.palder = palder;
		this.cont = cont;
	}
	
	public void run(){
		System.out.println("filosofo "+ n_filosofo +" pensando");
		cont.inc();
		//simula que esta pensando
		try{Thread.sleep(5000);}
		catch(InterruptedException e){}
		//termino de pensar
		
		System.out.println("filosofo "+ n_filosofo +" tiene hambre");
		palizq.tomarPalillo(n_filosofo);
		palder.tomarPalillo(n_filosofo);
		System.out.println("filosofo "+ n_filosofo +" come");
		
		//simula que esta comiendo
		try{Thread.sleep(5000);}
		catch(InterruptedException e){}
		//termino de comer
		
		palizq.soltarPalillo();
		palder.soltarPalillo();
		cont.dec();
		
	}
}