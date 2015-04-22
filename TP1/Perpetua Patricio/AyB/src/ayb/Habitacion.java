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
public class Habitacion implements Runnable
{
    private Proceso oA;
    private Proceso oB;
    
    public Habitacion(Proceso oA, Proceso oB)
    {
        this.oA = this.oA;
        this.oB = this.oB;
    }

    @Override
    public void run() 
    {
        
        
        for (int i = 0; i < 5; i++) 
        {
            oA.addCantidad();
            oB.addCantidad();
        }
        if(oB.)
    }
}
