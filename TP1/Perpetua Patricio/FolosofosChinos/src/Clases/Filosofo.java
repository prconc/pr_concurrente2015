/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pato
 */
public class Filosofo implements Runnable
{
    Palillo oPalillo;
    int iContador;
    String sNombre;
    public Filosofo()
    {
        iContador=0;
    }
    
    public Filosofo(Palillo oPalillo, String sNombre)
    {
        this.sNombre = sNombre;
        this.oPalillo = oPalillo;
        iContador=0;
    }
    
    @Override
    public void run() 
    {
        while (true) 
        {            
            comer();
            iContador++;
            System.out.println("Come el filosofo: "+ sNombre + " comio= "+iContador);
        }
    }
    public void comer()
    {        
        if(iContador>4)
        {
            System.out.println("El filosofo: "+ sNombre + " dejo de comer!");
            iContador=0;
            oPalillo.Soltar(sNombre);                   
        }
        else
        {                   
            if (oPalillo.Agarrar(sNombre)==0)
            {
                oPalillo.Soltar(sNombre);
            }
                
        }
    }

}
