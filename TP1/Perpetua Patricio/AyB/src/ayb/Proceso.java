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
public class Proceso 
{
    private int iCantidad;
    
    public Proceso()
    {
        iCantidad = 0;
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
}
