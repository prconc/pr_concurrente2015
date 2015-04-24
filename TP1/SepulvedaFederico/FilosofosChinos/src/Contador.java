/*
 * Esta clase evita que se produzca un interbloqueo, impidiendo que 4 filosofos
 * traten de comer al mismo tiempo
 */
public class Contador {
	int cont;
	int tope;
	
	Contador (int tope){
		cont=0;
		this.tope=tope;
	}
	
	public void inc (){
		while (cont==tope){
			try {wait();}//bloqueado por ser el quinto filosofo
			catch (Exception e){}
		}
		cont++;
	}
	
	synchronized public void dec(){
		cont --;
		notifyAll();
	}
	synchronized public int valor (){
		return cont;
	}

}
