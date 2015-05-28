/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

import Clases.Productor;
import Clases.Buffer;
import Clases.Consumidor;


/**
 *
 * @author Pato
 */
public class ProductorConsumidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Buffer oBuffer = new Buffer(10);
        Productor oProductor = new Productor(oBuffer);
        Consumidor oConsumidor = new Consumidor(oBuffer);
        Thread oThread = new Thread(oProductor);
        Thread oThread2 = new Thread(oConsumidor);
        oThread.start();
        oThread2.start();
    }
    
}
