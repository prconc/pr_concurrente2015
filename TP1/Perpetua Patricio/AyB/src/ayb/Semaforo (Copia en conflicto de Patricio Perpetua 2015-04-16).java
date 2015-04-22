package ayb;

public class Semaforo 
{
    private int contadorA;
    private int contadorB;
    
    public Semaforo(int contadorA, int contadorB)
    {
            this.contadorA = contadorA;
            this.contadorB = contadorB;
    }
    
    public Semaforo()
    {
        contadorA = 0;
        contadorB = 0;
    }
    
    synchronized public void WAIT(int v)
    {
        if(v == 0)
        {
            while(contadorB>=1 && contadorB>0)
            try
            {
                wait();
            }catch(Exception e)
            {
                
            }
        }
            contador--;
    }

    synchronized public void SIGNAL() 
    {
        contador=1;
        notify();
    }
}