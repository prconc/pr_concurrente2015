
public class Lector implements Runnable {

	int ID;
	Recurso recurso;
	
	public Lector (Recurso recurso,int ID){
		this.ID=ID;
		this.recurso=recurso;
	}
	
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println ("Lector " +ID+" quiere leer");
			recurso.leer();
			System.out.println ("Lector "+ID+" ha terminado");
		}
	}
}
