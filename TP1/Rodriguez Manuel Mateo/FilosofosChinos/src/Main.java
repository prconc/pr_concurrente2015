public class Main {

	    Filosofo f[]=new Filosofo[5];
		Palito palitos[]=new Palito[5];
		Contador contador;
		int numFil=5;
		
		public Main(){
			contador=new Contador(numFil-1);
		for(int i=0;i<numFil;i++){
			palitos[i]=new Palito();
		}
		for(int i=0;i<numFil;i++){
			f[i]=new Filosofo(i,contador,palitos[i],palitos[(i+1)%numFil]);
			Thread t1=new Thread(f[i]);
			t1.start();
		}
		
}
public static void main(String[] args) {
	// TODO Auto-generated method stub
	new Main();
 }
}