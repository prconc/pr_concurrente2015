
public class Main {
	 Filosofo filosofo[] = new Filosofo[5];
	 Palillo palillo[] = new Palillo[5];
	 int maximo = 5;
	 Contador contador;
	
	 public Main(){ 
		 contador = new Contador(maximo-1);
		 
		 for(int i=0; i<maximo ; i++){
			 palillo[i] = new Palillo();
		 } 
     
		 for(int j=0; j<maximo ; j++){
			 filosofo[j] = new Filosofo(j,palillo[j],palillo[(j+1)%maximo],contador);
		 }
	     for(int j=0; j<maximo ; j++){	 
			 Thread hilo1 = new Thread(filosofo[j]);
			 hilo1.start();
		 
		 }
		
	}
	
	 public static void main(String[] args) {
		new Main();
	}
}
