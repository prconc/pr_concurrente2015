
public  class Filosofo implements Runnable {
	
	
	int id;
	Palillo derecho;
	Palillo izquierdo;
	Contador contador;
	boolean comiendo;
	
	public Filosofo(int id, Palillo der, Palillo izq, Contador c){
		
		this.id = id;
		derecho = der;
		izquierdo = izq;
		contador = c;
		
		
	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			
			System.out.println(String.format("filosofo %s pensando",id));
			contador.incrementar();
			
			izquierdo.agarrar();
			derecho.agarrar();
			
			System.out.println(String.format("filosofo %s comiendo",id));
			
			try {
				Thread.sleep(500+(int)Math.random()*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			izquierdo.soltar();
			synchronized(this){
				System.out.println(String.format("filosofo %s termino de comer",id));
			}
			derecho.soltar();
			
			contador.decrementar();
			
			
		
		}
		
	}


}
