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
public class Buffer 
{
	private int[] valor;
    private int sub;
    public Buffer(int large) 
    {
            valor= new int[large];
            sub=0;
            for (int i = 0; i < valor.length; i++) 
            {
                    valor[i]=0;
            }
    }

    public synchronized void producir()
    {
            if (sub<valor.length && valor[sub]==0)
            {
                for (int i = 0; i < valor.length; i++) 
                {
                    System.out.print(valor[i] + ",");
                }
                System.out.print("\n");
                valor[sub]=9;
                sub++;
                if(sub==valor.length)
                        sub=9;
            }
            else
            {
                    int flag=0;
                    for (int i = 0; i < valor.length; i++) 
                    {
                            if(valor[i]==0)
                            {
                                    sub=i;
                                    flag=1;
                            }
                    }
                    if(flag==0)
                    {
                            try 
                            {                  
                                this.notifyAll();
                                this.wait();
                            } catch (InterruptedException e) 
                            {
                                System.out.print("Error al producir");
                            }
                    }
            }
    }

    public synchronized void consumir()
    {
            if (sub>-1 && valor[sub]==9)
            {
                for (int i = 0; i < valor.length; i++) 
                {
                    System.out.print(valor[i] + ",");
                }
                System.out.print("\n");
                valor[sub]=0;
                sub--;
                if (sub==-1)
                        sub=0;
            }
            else
            {
                    int flag=0;
                    for (int i = 0; i < valor.length; i++) 
                    {
                        if(valor[i]==9)
                        {
                                sub=i;
                                flag=1;					
                        }
                    }
                    if(flag==0)
                    {
                            try 
                            {
                                this.notifyAll();
                                this.wait();                                    
                            } catch (InterruptedException e) 
                            {
                                    System.out.print("Error al consumir");
                            }
                    }
            }
    }

    public int getValor()
    {
            if(sub>1)
                    return this.valor[sub--];
            else
                    return 0;
    }
}
