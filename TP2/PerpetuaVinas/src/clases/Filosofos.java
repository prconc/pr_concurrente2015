package clases;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Filosofos extends Thread{

	private Monitores oMonitor;
	private String sNombre;	
        private int[][] disparoA;
        private int[][] disparoB;
        
	public Filosofos(Monitores oMonitor)
	{
		this.oMonitor = oMonitor;
	}
	
	@Override
	public void run() 
	{
            while (true)
            {                          
                try 
                {
                    Thread.sleep(20);
                    oMonitor.Comer(sNombre,disparoA,disparoB);
                } catch (InterruptedException ex) 
                {
                    System.out.println("Error Sleep" + ex.getMessage());                
                }
            }
	}

	public void setsNombre(String sNombre)
	{
		this.sNombre = sNombre;
	}
	
	public String getsNombre()
	{
		return sNombre;
	}

        public int[][] getDisparoA() 
        {
            return disparoA;
        }
        
        public int[][] getDisparoB() 
        {
            return disparoB;
        }

        public void setDisparo(int[][] disparoa, int[][] disparob) 
        {
            this.disparoA = disparoa;
            this.disparoB = disparob;
            
        }
        
}
