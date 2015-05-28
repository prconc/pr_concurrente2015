/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Pato
 */
public class Palillo 
{
    private String[] numerodePalillo; 
    
    public Palillo(int n)
    {
        numerodePalillo = new String[n];
        for (int i = 0; i < numerodePalillo.length; i++) 
        {
            numerodePalillo[i]="";//todos los palillos estan disponibles.
        }
    }
    
    public synchronized int Agarrar(String filosofo)
    {
        int pal=0;
        for (int i = 0; i < numerodePalillo.length; i++) 
            if(numerodePalillo[i].equals(filosofo))
                pal++;
        if (pal <2)
            for (int i = 0; i < numerodePalillo.length; i++)
                if (numerodePalillo[i].equals("") && pal<2)
                {
                    numerodePalillo[i]=filosofo;
                    pal++;
                }        
        if (pal==2)
            return 1;//palillo disponible
        else
            return 0;// palillo no disponible
    }
    
    public synchronized void Soltar(String filosofo)
    {
        for (int i = 0; i < numerodePalillo.length; i++) 
        {
            if(numerodePalillo[i].equals(filosofo))
                numerodePalillo[i]="";
        }
        
        try 
        {
            System.out.println("Piensa el filosofo: "+ filosofo);
            this.notifyAll();
            this.wait();
        } catch (InterruptedException ex) 
        {
            System.out.println("Error en wait: "+ ex + "\n");
        }
    }
    
}
