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
public class Productor implements Runnable {

	private Buffer oBuffer;
	@Override
	public void run() 
	{
		while(true)
		{
			oBuffer.producir();
		}
	}

	public Productor (Buffer oBuffer)
	{
		this.oBuffer = oBuffer;
	}
}
