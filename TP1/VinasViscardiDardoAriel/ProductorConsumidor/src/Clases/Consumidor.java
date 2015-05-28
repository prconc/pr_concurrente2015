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
public class Consumidor implements Runnable 
{

	Buffer oBuffer;
	@Override
	public void run() 
	{
		while (true)
		{
			oBuffer.consumir();
		}
	}

	public Consumidor(Buffer oBuffer)
	{
		this.oBuffer = oBuffer;
	}
}
