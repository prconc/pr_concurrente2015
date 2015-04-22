public class Lector implements Runnable{
	int __lector__;
	Recurso __recurso__;
	
	public Lector(Recurso recurso, int lector){
		__lector__ = lector;
		__recurso__ = recurso;
	}
	
	public void run(){
		int i = 0;
		while(i < 10){
			System.out.println("Escritor "+ __lector__ + " quiere escribir");
			__recurso__.leer();
			System.out.println("Escritor "+ __lector__ + " ha terminado de escribir");
			i++;
		}
	}
}
