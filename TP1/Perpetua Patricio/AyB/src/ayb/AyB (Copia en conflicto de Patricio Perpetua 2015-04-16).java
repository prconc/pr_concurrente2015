/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayb;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pato
 */
public class AyB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Semaforo oSemaforo = new Semaforo();
        ProcesoA oProcesoA = new ProcesoA(oSemaforo);
        ProcesoB oProcesoB = new ProcesoB(oSemaforo);
        
        for (int i = 0; i < 10; i++) 
        {
            oProcesoA.addCantidad();
            oProcesoB.addCantidad();
        }
        
        oProcesoA.setProceso(oProcesoB);
        Thread oThread = new Thread(oProcesoA);
        Thread oThread1 = new Thread(oProcesoB);
        
        oThread.start();
        oThread1.start();
    }
    
}
