
public class Filosofos extends Thread
{
	private int Ta;//Transición para tomar los palillos
	private int Tb;//Transición para dejar los palillos
	private Monitor Mo;
	private int yo;
	private int[] auxM;
	
	public Filosofos(int a, int b, Monitor m, int y)
	{
		yo = y;
		Ta = a;
		Tb = b;
		Mo = m;
	}
	
	public void run()
	{
		while(true)
		{
			System.out.println("El filosofo "+ yo +" esta leyendo");
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("le dio hambre al filosofo " + yo);
			
			Mo.comer(Ta,yo);
			
			System.out.println(yo + " paso la barrera");
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("el filosofo " + yo + " termino de comer  ");
			
			Mo.dejarDeComer(Tb,yo);
		}
		
	}
}
