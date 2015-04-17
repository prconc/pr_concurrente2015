
public class Mesa {

	 	Semaforo cubierto[];  
		
		public Mesa()
		{  
			
			cubierto=new Semaforo[5];
		
			for(int i=0; i<5; i++)
			{  
				cubierto[i] = new Semaforo(i);
		  
			}  
		 
		} 
		
		
		public Semaforo getTenedor(int x){  
			return cubierto[x];  
		 }  
		
		public int getT_Right(int x){  
			return (x+1)%5;  
		 }  
		
		public int getT_Left(int x){  
			return x;  
		 }  
		

}  

