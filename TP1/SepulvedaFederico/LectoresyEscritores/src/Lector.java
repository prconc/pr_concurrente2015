
public class Lector extends Thread {
	int miId;
	Recurso recurso;
	
	public Lector (Recurso recurso, int miId){
		this.miId=miId;
		this.recurso=recurso;
	}
	
	public void run(){
		int i=0;
		while (i<10){
			System.out.println("Lector "+miId+" quiere leer");
			recurso.leer();
			System.out.println("Lector "+miId+" ha terminado");
			i++;
		}
	}

}
