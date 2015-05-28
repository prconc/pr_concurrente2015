package clases;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitores 
{
    private Lock lock = new ReentrantLock();			//lock para exclusi�n mutua
    private Condition comer = lock.newCondition();				
    private boolean waiting=false;
    private Redes oRed;
    public Monitores(Redes oRed) 
    {
            this.oRed = oRed;
    }

    public void Comer(String sNombre, int[][] disparoa, int[][] disparob)
    {
            lock.lock();
            try
            {
                while(!oRed.ejecutar(disparoa))//disparo para poder comer.
                {
                    System.out.println(sNombre+" se fue a pensar.");
                    try 
                    {
                        comer.await();
                    } catch (InterruptedException ex) 
                    {
                        System.out.println(ex.getMessage());
                    }
                }
                System.out.println(sNombre + " esta comiendo");
                oRed.ejecutar(disparob);//disparo para devolver los palitos.
                comer.signal();
            }
            finally
            {
//                    System.out.println(sNombre + " libero los palitos");
                    lock.unlock();
            }
    }     
}
