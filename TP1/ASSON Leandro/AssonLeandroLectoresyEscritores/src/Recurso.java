public class Recurso
{
int numlectores;
boolean hayescritor;
int vector[];
int tamaño;

public Recurso(int tamaño)
{
	hayescritor=false;
    numlectores=0;
    vector = new int[tamaño];
    this.tamaño=tamaño;
    
}

public void escribir(int valor,int posicion)
{
	synchronized(this)
	{
		while(hayescritor || (numlectores>0)) //Si ya hay alguien escribiendo o Lectores esperando para leer esperar
		{
			try {
				wait();
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	hayescritor = true;
	}
	
	if(tamaño > posicion)
		vector[posicion] = valor;		//EN este punto escribimos
	
	synchronized(this)
	{
		hayescritor = false;
		notifyAll();
	}
	
	
}

	
public void leer(int posicion)
{
	//condicion para entrar a leer
	synchronized(this)
	{
		while(hayescritor)
		{
			try{wait();}
			catch(Exception c){}
		}
		numlectores ++;
		
	}
	
	synchronized(this)
	{
		numlectores--;
		if(numlectores==0){notifyAll();}
	}
	
}

public int getvalorlectura(int posicion)
{
	return vector[posicion];
} 




}
