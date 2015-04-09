
public class Main 
{
	public static void main(String[] args) 
	{
		Palillo[] palillos= new Palillo[5]; //Arreglo que contiene los 5 palillos de la mesa
		Filosofo[] filosofos= new Filosofo[5]; //Arreglo de los 5 filosofos
		
		for(int i=0;i<5;i++)
		{
			palillos[i] = new Palillo(i); //Creamos primero los palillos para que luego puedan ser asignados
		}
		
		for(int i=0;i<5;i++)
		{
			int seg_palillo = ((i+1)%5);
			filosofos[i] = new Filosofo(i,palillos);
			
			Thread hilo = new Thread(filosofos[i]);
			hilo.setName("F: " + i + " PD: " + i + " PI: " + seg_palillo);
			
			hilo.start();
		}
	}
}
