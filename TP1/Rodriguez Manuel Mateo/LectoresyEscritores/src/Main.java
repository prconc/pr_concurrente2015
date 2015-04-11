
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Recurso r1=new Recurso();
		
		
		for(int i=0;i<3;i++)
		{
			Escritor e1=new Escritor(r1,i);
			Lector l1=new Lector(r1,i);
			Thread t1=new Thread(e1);
			Thread t2=new Thread(l1);
			t1.start();
			t2.start();
		}
	}
}
