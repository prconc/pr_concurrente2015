import java.util.Random;


public class Buffer {
	
	private boolean hayEscritor;
	private int[] bufferLineal;
	private int punteroEscritor;
	private int numLectores;
	private int contador;
	
	public Buffer() {
	
		hayEscritor = false;
		bufferLineal = new int[16];
		for(int i = 0; i<16; i++) {
			bufferLineal[i] = 0;
		}
		punteroEscritor = 0;
		numLectores = 0;
		contador = 1;
	}
	
	synchronized public boolean escribir(int id) {
		
		synchronized (this) {
			while (hayEscritor || numLectores>0){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			hayEscritor = true;
		}
		
		if (punteroEscritor<16) {
			bufferLineal[punteroEscritor] = contador;
			punteroEscritor++;
			contador++;
			System.out.println("El escritor "+id+" escribio. Buffer: "+bufferLineal[0]+" "+bufferLineal[1]+" "+bufferLineal[2]+" "+bufferLineal[3]+" "+bufferLineal[4]+
					" "+bufferLineal[5]+" "+bufferLineal[6]+" "+bufferLineal[7]+" "+bufferLineal[8]+" "+bufferLineal[9]+
					" "+bufferLineal[10]+" "+bufferLineal[11]+" "+bufferLineal[12]+" "+bufferLineal[13]+" "+bufferLineal[14]+
					" "+bufferLineal[15]);
			
			synchronized (this) {
				hayEscritor = false;
				notifyAll();
			}
			return false;
		} else {
			System.out.println("El escritor "+id+" no escribio porque ya esta lleno el buffer.");
			synchronized (this) {
				hayEscritor = false;
				notifyAll();
			}
			return true;
		}
	}
	
	public void leer() {
		
		synchronized (this) {
			while (hayEscritor || punteroEscritor==0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			numLectores++;
		}
		
		// Lectura
		try {
			Random rand = new Random();
			Thread.sleep(rand.nextInt(200));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//
		
		synchronized (this) {
			numLectores--;
			if (numLectores==0) notifyAll();
		}		
	}
}
