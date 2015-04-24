
public class MainLyE {
	public static void main (String args[]){
		Recurso recurso=new Recurso();
		for (int i=0;i<3;i++)
			new Lector (recurso,i).start();
		
		for (int i=0;i<3;i++)
			new Escritor(recurso,i).start();
	}
	

}
