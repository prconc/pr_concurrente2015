
public class buffer {
	int capacidad;		//capacidad del buffer.
	int [] datos;		//Se usan enteros por facilidad para distinguirlos.
	int cantidad;		//cantidad de plazas ocupadas en el buffer.
	

	public buffer() {
		// TODO Auto-generated constructor stub
		capacidad=100;
		datos=new int[capacidad];
		cantidad=0;
	}
	
	synchronized public void producir(int dato)
	{
		//No deja producir cuando el buffer está lleno.
		while(cantidad >= capacidad){
			try{
				print("No hay más lugar para producir");
				wait();
				}
			catch (InterruptedException e) {
				e.printStackTrace();
				}
			}
		
		datos[cantidad] = dato;
		print("Se agregó: "+dato +"; en Datos[" + cantidad + "].");
		cantidad++;
		
		notifyAll();
		return;
	}
	
	synchronized public void consumir()
	{
		//No deja consumir cuando el buffer está vacío.
		while(cantidad <= 0){
			try{
				print("No hay qué consumir.");
				wait();
				}
			catch (InterruptedException e) {
				e.printStackTrace();
				}
			}
		
		datos[cantidad] = -1;
		cantidad--;
		print("Se consumió un valor");
		
		notifyAll();
		return;
		}

	public static void print(String s){
		System.out.println(s);
		}

}
