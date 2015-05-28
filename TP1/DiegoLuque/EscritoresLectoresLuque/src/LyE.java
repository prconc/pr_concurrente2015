
public final class LyE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Recurso recurso = new Recurso();
		
		for (int i=0;i<3;i++)
			new Lector (recurso,i).start();
		
		for (int i=0; i<3;i++)
			new Escritor (recurso,i).start();
	}

}
