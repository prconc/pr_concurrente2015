
public class Filosofo implements Runnable{
	//La clase filosofo cuenta con un numero de filosofo para poder distinguirlo de los demas
	//y se le permite agarrar o soltar los palillos que tenga a su derecha e izquierda
	//El filosofo intentara comer cuanto antes, de no ser eso posible pensara hasta que se desocupen los palillos
	int indice;
	Palillo izq,der;
	
	Filosofo(int num, Palillo izq, Palillo der){
		indice = num;
		this.izq = izq;
		this.der = der;
	}
	
	public void pensar(){
		try {
			System.out.println("El Filosofo numero: " + indice + " esta pensando!");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	synchronized public void comer(){
		while(!(izq.isLibre() && der.isLibre()))
		{
			pensar();
		}
		izq.agarrar();
		der.agarrar();
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		izq.soltar();
		der.soltar();
		System.out.println("El Filosofo numero: " + indice + " comió!Usó palillos "+ izq.getIndice() +" y " + der.getIndice());
		notifyAll();
	}

	public void run() {
		// TODO Auto-generated method stub
		comer();
	}
	
}
