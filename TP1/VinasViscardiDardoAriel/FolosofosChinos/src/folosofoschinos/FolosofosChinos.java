/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folosofoschinos;

import Clases.Filosofo;
import Clases.Palillo;

/**
 *
 * @author Pato
 */
public class FolosofosChinos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Palillo oPalillo = new Palillo(5);
        Filosofo oFilosofo = new Filosofo(oPalillo,"1");
        Filosofo oFilosofo2 = new Filosofo(oPalillo,"2");
        Filosofo oFilosofo3 = new Filosofo(oPalillo,"3");
        Filosofo oFilosofo4 = new Filosofo(oPalillo,"4");
        Filosofo oFilosofo5 = new Filosofo(oPalillo,"5");
        Thread oThread = new Thread(oFilosofo);
        Thread oThread2 = new Thread(oFilosofo2);
        Thread oThread3 = new Thread(oFilosofo3);
        Thread oThread4 = new Thread(oFilosofo4);
        Thread oThread5 = new Thread(oFilosofo5);
        oThread.start();
        oThread2.start();
        oThread3.start();
        oThread4.start();
        oThread5.start();
    }
    
}
