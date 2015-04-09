import java.util.Random;

public class Lector implements Runnable
{
 private Recurso recurso;
 private int numlector;
 private int numoperaciones =10;
 private Random pos;
 

public Lector(Recurso recurso, int numlector)
{
this.recurso=recurso;
this.numlector=numlector;
pos= new Random();
}

public void run()
{
	for(int i=0;i<numoperaciones;i++)
	{
		int posicion = pos.nextInt(10);
		System.out.println("El lector "+numlector+" esta intentando leer el archivo en la posicion " + posicion);
		recurso.leer(posicion);
		//tiempo que tarda en leer el archivo.
		try{Thread.sleep(5);}
		catch(Exception c){}
		
		System.out.println("El lector "+numlector+" termino de leer el valor: " + recurso.getvalorlectura(posicion)+" de la posicion "+posicion);
		
	} 
	
	
}
	
	
	
}
