import java.util.Random;

public class Escritor implements Runnable
{
 private Recurso recurso;
 private int numoperaciones =10;
 int numescritor;
 int posicion;
 int valor;
 private Random pos;
 private Random val;


public Escritor(Recurso recurso, int numescritor)
{
this.recurso=recurso;
this.numescritor=numescritor;
pos= new Random();
val= new Random();
}

public void run()
{
	for(int i=0;i<numoperaciones;i++)
	{
		posicion = pos.nextInt(10);
		valor = val.nextInt(100);
		
		System.out.println("El Escritor "+numescritor+" esta intentando escribir el archivo en la posicion " + posicion);
		recurso.escribir(valor,posicion);
		//tiempo que tarda en escribir el archivo.
				try{Thread.sleep(10);}
				catch(Exception c){}
		System.out.println("El Escritor "+numescritor+" termino de escribir el valor: " + valor +" de la posicion "+ posicion);
		
	} 
	
	
}
	
	
	
}