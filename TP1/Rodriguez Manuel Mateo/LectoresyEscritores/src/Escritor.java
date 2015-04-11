
public class Escritor implements Runnable {

	int ID;
	Recurso recurso;
	
	public Escritor(Recurso recurso,int ID){
		this.ID=ID;
		this.recurso=recurso;
	}
	
	public void run (){
		for(int i=0;i<10;i++){
			System.out.println ("Escritor " +ID+" quiere escribir");
			recurso.escribir();
			System.out.println ("Escritor "+ID+" ha terminado");
		}
	}

}
