
public class Main
{

public static void main(String[] args)
	
	{
		 
         Palillo palillo[]= new Palillo[5];
         int numerodefilosofos =5;
         Contador contador = new Contador(numerodefilosofos-1);
              	
		
        // Creo los 5 palillos chinos.
         for(int i=0; i<numerodefilosofos;i++)
		{
			palillo[i] = new Palillo(i);
			System.out.println("Se genero el palillo "+i);
		}
         
        //Creo los 5 hilos para los 5 filosofos. 
		for(int i=0; i<numerodefilosofos;i++)
		{
			
			Filosofo filosofo = new Filosofo(i,contador,palillo[i],palillo[(i+1)%numerodefilosofos]);
			Thread f1 = new Thread(filosofo);
			f1.setName("Filosofo "+i);
			
			f1.start();
		}
	
	}

}
