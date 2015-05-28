package clases;

public class Filosofos extends Thread{

	private Monitores oMonitor;
	private String sNombre;	
	public Filosofos(Monitores oMonitor)
	{
		this.oMonitor = oMonitor;
	}
	
	@Override
	public void run() 
	{
            while (true)
                oMonitor.Comer(sNombre);		
	}

	public void setsNombre(String sNombre)
	{
		this.sNombre = sNombre;
	}
	
	public String getsNombre()
	{
		return sNombre;
	}
}
