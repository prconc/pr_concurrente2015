
public class Buffer {

	int numeroLectores=0;
	boolean escritordisponible= false;
	
		
		 public void leer(){
			synchronized (this){
			while (escritordisponible)
				try{
					wait();
				   }
				catch(InterruptedException e){
					
						e.printStackTrace();
											}
					numeroLectores++;
			         			}
			synchronized (this){
			numeroLectores--;
			if(numeroLectores==0)
				notifyAll();
			
								}
		 				}
		synchronized public void escribir(){	
			
			while(escritordisponible || (numeroLectores>0))
				try{
					wait();
					
				   }
				catch(InterruptedException e){
					
						e.printStackTrace();
											}
				escritordisponible=true;
										
		escritordisponible=false;
		notifyAll();
											}

						}


		
