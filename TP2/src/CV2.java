import java.util.Vector;
public class CV2 {
	Vector bloqueados; 
	boolean condSalida; 
	String nombre; 
	static Vector condicion; 
	
	public CV2(String _nombre) 
	{
		nombre = _nombre;
		condSalida = false;
		bloqueados = new Vector(50);
		condicion = new Vector(10);
	}
	
	public void DELAY(Object monitor) 
	{
		synchronized(monitor) { 
			try {	bloqueados.addElement (Thread.currentThread());
				do {
					monitor.wait();
					condSalida = bloqueados.firstElement().equals
					(Thread.currentThread()) && condicion.contains
					(nombre);
						if(!condSalida) monitor.notify();
				}
				while(!condSalida);
				condSalida = false;
				bloqueados.removeElement(Thread.currentThread());
				condicion.removeElement(nombre);
			} catch(Exception e) {e.printStackTrace();}
		}
	}
	
	public void RESUME(Object monitor) {
		synchronized(monitor) {
					if(bloqueados.size() > 0) {
					condSalida = false;
					if(!condicion.contains(nombre))
						condicion.addElement (nombre);
					monitor.notify();
					return;
				}
		}
	}


	
	public boolean EMPTY(Object monitor) {
		synchronized(monitor) {
			if(bloqueados.size() > 0) return false;
			else return true;
		}
	}
}
