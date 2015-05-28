package clases;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Monitores 
{
    private Lock lock = new ReentrantLock();			//lock para exclusi�n mutua
    private Condition comer = lock.newCondition();				
    private boolean waiting=false;
    private Redes oRed;
    private int disparo[][];
    public Monitores(Redes oRed) 
    {
            this.oRed = oRed;
    }

    synchronized public void Comer(String sNombre)
    {
            lock.lock();
            try
            {
                while(!oRed.ejecutar(disparo))
                {
                    try 
                    {
                        this.wait();
                    } catch (InterruptedException ex) 
                    {
                        System.out.println("");
                    }
                }
                System.out.println(sNombre + " esta comiendo");
            }finally
            {
                    lock.unlock();
            }
    }     
}
