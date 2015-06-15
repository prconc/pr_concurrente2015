
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mesa mesa= new Mesa();
		for(int i=0;i<5;i++)
		{
			new Thread (new Filosofo(mesa,i)).start();
		}
	}

}
