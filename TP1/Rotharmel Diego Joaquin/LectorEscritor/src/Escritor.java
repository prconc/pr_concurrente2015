public class Escritor implements Runnable{
	int __escritor__;
	Recurso __recurso__;
	
	public Escritor(Recurso recurso, int escritor){
		__escritor__ = escritor;
		__recurso__ = recurso;
	}
	
	public void run(){
		int i = 0;
		while(i < 10){
			System.out.println("Escritor "+ __escritor__ + " quiere escribir");
			__recurso__.escribir();
			System.out.println("Escritor "+ __escritor__ + " ha terminado de escribir");
			i++;
		}
	}
}
