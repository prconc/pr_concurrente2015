
public class Filosofo extends Thread {
	

		private Mesa cena;
		private int t_izq, t_der;  
		private int numero; 
		

		public Filosofo (int x, Mesa cena){  
		      
			  this.numero= x;
		      this.cena= cena; 
		      
		      t_izq= cena.getT_Left(numero);  
		      t_der= cena.getT_Right(numero);  
		      
		   }  

		private void pensar()
		{
			try {
				
				System.out.println("Filosofo "+numero+" pensando");
				int rand= (int)(Math.random()*1000);
				sleep(rand);
				
				}
			
			catch (InterruptedException e) {
			}
				
		}
		
		
		private void comer()
		{
			try {
				
				System.out.println("Filosofo "+numero+" comiendo");
				int rand=(int)(Math.random()*1000);
				sleep(rand);
				
				}
			
			catch (InterruptedException e) {
			}
			
			
		}

		
		
		private void agarrarTenedores(){
			  
		     Semaforo t1= cena.getTenedor(t_izq);  
		     Semaforo t2= cena.getTenedor(t_der);  
		     t1.Wait();  
		     t2.Wait();  
		}  
		
		private void dejarTenedores(){  
		       
		     Semaforo t1= cena.getTenedor(t_izq);  
		     Semaforo t2= cena.getTenedor(t_der);  
		     t1.Signal();  
		     t2.Signal();  
		} 


		public void run(){  
		      while(true){  
		         pensar();  
		         agarrarTenedores();  
		         comer();  
		         dejarTenedores();  
		      }
		      
		}

}

