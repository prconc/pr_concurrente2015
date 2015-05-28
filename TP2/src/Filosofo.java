
public class Filosofo implements Runnable {
	Mesa mesa;
	int id;
	
	public Filosofo (Mesa _mesa,int _id)
	{
		mesa= _mesa;
		id= _id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++)
		{
			System.out.println("Filosofo "+ id +" pensando");
			try{Thread.sleep(1000);}
			catch (Exception e){}
			mesa.tomar(id);
			System.out.println("Filosofo "+ id + " comiendo");
			try{Thread.sleep(1000);}
			catch(Exception e){}
			mesa.poner(id);
		}
	}
}
