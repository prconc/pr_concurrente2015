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
public class ProcesoA implements Runnable
{
    private int iCantidad;
    private ProcesoB oProceso;
    private Semaforo oSemaforo;
    
    public ProcesoA(Semaforo oSemaforo)
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
        oSemaforo.SIGNAL();
    }
    
    public void delCantidad()
    {
        iCantidad--;
    }

    public void setProceso(ProcesoB oProceso)
    {
        this.oProceso = oProceso;
    }
    
    public ProcesoB getProceso()
    {
        return oProceso;
    }

    @Override
    public void run() 
    {
        while (true) 
        {                                 
            if (oProceso.getCantidad()>=2 && oProceso.getCantidad()>0)
            {
                oProceso.delCantidad();
                addCantidad();
                System.out.println("Elimino un proceso A");                        
            }
            else
            {
                oSemaforo.SIGNAL();
               oSemaforo.WAIT();
            }
        }
    }
    
}
