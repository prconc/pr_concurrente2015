
public class Main
{

	public static void main(String[] args) 
	{
	
		buffer Buffer = new buffer();
		
		for(int i=1; i<5; i++)
		{
				Generador generador=new Generador(Buffer);
			Thread h1 = new Thread(generador);
			h1.setName("GEN"+ i);
				
			    Consumidor consumidor=new Consumidor(Buffer);
			Thread h2 = new Thread(consumidor);
			h2.setName("CON"+ i);
			
			
			h1.start();
			h2.start();
		}
		
		
	}
		
		

}

