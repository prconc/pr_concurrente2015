package Clases;

public class Buffer { //No es un thread.
	private int cima, capacidad, vector[];
	
	Buffer (int i) {
		cima = 0;
		capacidad = i;
		vector = new int[i];
	}
	
	synchronized public int extraer () {
		while (cima == 0)
			try {
				wait();
			} catch (InterruptedException e) {;}
		notifyAll();
		return vector[--cima];
	}
	
	synchronized public void insertar (int elem) {
		while (cima == capacidad-1)
			try {
				wait();
			} catch (InterruptedException e) {;}
		vector[cima] = elem;
		cima++;
		notifyAll();
	}	
}
