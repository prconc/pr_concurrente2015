
public class Main {
	static Buffer buf=new Buffer(3);// se crea un buffer con capacidad 3
	
	public static void main (String[] args){
		for (int i=1;i<=5;i++)
			new Productor (buf,i).start();
		for(int j=1;j<=5;j++)
			new Consumidor (buf,j).start();
		System.out.println("Fin del hilo main");
		
	}

}
