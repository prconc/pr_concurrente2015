
public class Main {
	
	static int n=5;
	static Palito palitos []= new Palito[n];
	static Filosofo filosofos []= new Filosofo[n];
	
	public static void main(String[] args) {
		
		for (int i=0;i<5;i++){palitos[i]=new Palito(i);}
		
		filosofos [0]= new Filosofo(0,palitos[0],palitos[1]);
		filosofos [1]= new Filosofo(1,palitos[1],palitos[2]);
		filosofos [2]= new Filosofo(2,palitos[2],palitos[3]);
		filosofos [3]= new Filosofo(3,palitos[3],palitos[4]);
		filosofos [4]= new Filosofo(4,palitos[4],palitos[0]);
		
		for (int i=0;i<5;i++){
			new Thread(filosofos[i]).start();
		}
				
		
		
	}

}
