
public class Buffer {
int posicion, capacidad, buffer[];
	
	Buffer(int capacidad){
		this.capacidad = capacidad;
		posicion = 0;
		buffer = new int[capacidad];
		}
	
	synchronized public void agregar(int elem){
		
		if(posicion < capacidad){
			buffer[posicion] = elem;
			System.out.println("se agrego algo");
			posicion++;
			notify();
		}
		else{
			try{
				wait();
				agregar(elem);
			}
			catch(InterruptedException e){e.printStackTrace();}
		}
	}
	synchronized public int quitar(){
		
		if(posicion > 0){
			posicion--;
			notify();
			return buffer[posicion];
			}
		else{
			try{
				wait();
				quitar();
			}
			catch(InterruptedException e){e.printStackTrace();}
			return -1;
		}
	}

}
