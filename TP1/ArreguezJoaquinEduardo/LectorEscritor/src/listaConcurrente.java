import java.util.ArrayList;

/*
 * Puede haber más de un lector a la vez.
 * No se puede leer mientras se escribe 
 */
public class listaConcurrente{
	ArrayList<String> datos;
	boolean escritor;
	int cantLectores;

	public listaConcurrente() {
		datos = new ArrayList<String>();
		escritor=false;
		cantLectores=0;
	}
	
	public int indices(){
		
		int indices;
		if (datos.size()==0)	{indices=1;}
		else {indices=datos.size();}
		
		return indices;
	}
	
	synchronized public void escribir(String s){
		
		while(escritor || cantLectores>0){
			try{wait();}
			catch(Exception e){e.printStackTrace();}
		}
		escritor=true;
		datos.add(s);
		print("Se escribio sobre el índice "+datos.size());
		escritor=false;
		notifyAll();
	}
	
	synchronized public String leer(int i){
		
		cantLectores++;
		print("Hay "+cantLectores+" lectores.");
		
		while(escritor || i>datos.size()){
			
			try{print("Ese dato no está disponible!.");wait();}
			catch(Exception e){e.printStackTrace();}
			
		}
		
		cantLectores--;
		notifyAll();
		return datos.get(i);
		
	}
	
	public static void print(String s){
		System.out.println(s);
	}


	


}
