/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayb;

/**
 *
 * @author Pato
 */
public class ProcesoB implements Runnable
{
    private int iCantidad;
    private ProcesoA oProceso;
    private Semaforo oSemaforo;
    
    public ProcesoB(Semaforo oSemaforo)
    {
        iCantidad = 0;
        this.oSemaforo = oSemaforo;
    }
    
    public int getCantidad()
    {
        return iCantidad;
    }
    
    public void addCantidad()
    {
        iCantidad++;
    }
    
    public void delCantidad()
    {
        iCantidad--;
    }

    public void setProceso(ProcesoA oProceso)
    {
        this.oProceso = oProceso;
    }
    
    public ProcesoA getProceso()
    {
        return oProceso;
    }

    @Override
    public void run() 
    {
        while (true) 
        {
            if (oProceso.getCantidad()>=1 && getCantidad()>0)
            {
                oProceso.delCantidad();
                addCantidad();
                System.out.println("Elimino un proceso B");
            }
            else
            {
                oSemaforo.SIGNAL();
               oSemaforo.WAIT();
            }
                
        }
    }
}
