public class Filosofo implements Runnable{
	int __numFilosofo__;
	Palillo __palilloDer__, __palilloIzq__;
	Contador __cont__;
	int __operaciones__;
	
	
	public Filosofo(int numFilosofo, Contador cont, Palillo palilloDer, Palillo palilloIzq){
		__numFilosofo__ = numFilosofo;
		__cont__ = cont;
		__palilloDer__ = palilloDer;
		__palilloIzq__ = palilloIzq;
		__operaciones__ = 10;
	}
	
	public void run(){
		for(int i = 0 ; i < __operaciones__ ; i++){
			System.out.println("Filosofo "+__numFilosofo__+" pensando");
			__cont__.incrementar();
			__palilloDer__.agarrar(__numFilosofo__);
			__palilloIzq__.agarrar(__numFilosofo__);
			System.out.println("Filosofo "+__numFilosofo__+" comiendo");
			try{
				Thread.sleep(1000+(int)Math.random()*500);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			__palilloDer__.soltar();
			__palilloIzq__.soltar();
			__cont__.decrementar();
		}
	}
}
