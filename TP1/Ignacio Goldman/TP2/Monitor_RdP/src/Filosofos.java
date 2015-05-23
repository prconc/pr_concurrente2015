public class Filosofos implements Runnable{
	    int indice;										    								
	    Monitor monitor;							
		
	    int [] disparocomer = new int [10]; //10 es la cantidad de transiciones que tengo en la red de petri  
		int [] disparoterminar = new int [10];
		
		
		Filosofos(int num, Monitor monitor){
			indice = num;
			this.monitor = monitor;
		
			switch(indice){
			
			case 0:
				disparocomer = new int []    {1,0,0,0,0,0,0,0,0,0}; //disparo que genera que el filosofo 0 coma 
				disparoterminar = new int [] {0,1,0,0,0,0,0,0,0,0}; //disparo que genera que el filosofo 0 termine de comer
			break;
			case 1:
				disparocomer = new int []    {0,0,0,1,0,0,0,0,0,0};  
				disparoterminar = new int [] {0,0,1,0,0,0,0,0,0,0}; 
			break;
			case 2:
				disparocomer = new int []    {0,0,0,0,0,1,0,0,0,0};  
				disparoterminar = new int [] {0,0,0,0,1,0,0,0,0,0}; 
			break;
			case 3:
				disparocomer = new int []    {0,0,0,0,0,0,0,1,0,0};  
				disparoterminar = new int [] {0,0,0,0,0,0,1,0,0,0};
			break;
			case 4:
				disparocomer = new int []    {0,0,0,0,0,0,0,0,0,1};
				disparoterminar = new int [] {0,0,0,0,0,0,0,0,1,0};
			break;
			}
				
		}
		
		public void pensar()
		{
			try
			{
				System.out.println("El filosofo " + indice + " está pensando...");
				Thread.sleep(5000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		public int getIndice()
		{
			return indice;
		}
		
		public void run() {	
			int i = 0;
		while(i<5)
		{
			pensar();
			monitor.comer(this);
			i++;
		}
	}
}

