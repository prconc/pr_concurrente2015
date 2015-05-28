import java.util.Vector;

public class Filosofo implements Runnable
{
	public int id;
	private Monitor monitor;	
	public Vector<int[]> disparos;
	public RedPetri red;
	public boolean disparo = false;
	
	
	int [] disparo0 = new int [] {1,0,0,0,0,0,0,0,0,0};
	int [] disparo1 = new int [] {0,1,0,0,0,0,0,0,0,0};
	int [] disparo2 = new int [] {0,0,1,0,0,0,0,0,0,0};
	int [] disparo3 = new int [] {0,0,0,1,0,0,0,0,0,0};
	int [] disparo4 = new int [] {0,0,0,0,1,0,0,0,0,0};
	int [] disparo5 = new int [] {0,0,0,0,0,1,0,0,0,0};
	int [] disparo6 = new int [] {0,0,0,0,0,0,1,0,0,0};
	int [] disparo7 = new int [] {0,0,0,0,0,0,0,1,0,0};
	int [] disparo8 = new int [] {0,0,0,0,0,0,0,0,1,0};
	int [] disparo9 = new int [] {0,0,0,0,0,0,0,0,0,1};
	
	public Filosofo(int id, Monitor mo, RedPetri red)
	{
		this.id = id;
		monitor = mo;
		this.red = red;
		
		disparos = new Vector<int[]>();
		
		disparos.add(disparo0);
		disparos.add(disparo1);
		disparos.add(disparo2);
		disparos.add(disparo3);
		disparos.add(disparo4);
		disparos.add(disparo5);
		disparos.add(disparo6);
		disparos.add(disparo7);
		disparos.add(disparo8);
		disparos.add(disparo9);
		
	}
	
	public void pensar()
	{
		try
		{
			System.out.println("El filosofo " + (id/2) + " está pensando...");
			Thread.sleep(3000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public void run()
	{	int i = 0;
		while(i<5)
		{
			pensar();
			monitor.comer(this);
			i++;
		}
	}
	public int[] getdisparo(int id)
	{
		return disparos.get(id);
		
	}
}
