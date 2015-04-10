
public class Main {
		static Buffer buf = new Buffer(3);
		public static void main(String[] args){
			// TODO Auto-generated method stub
			for(int i=1;i<=5;i++)
				{
				Productor a= new Productor (buf);
			    Thread t1 = new Thread(a);
				t1.start();
				}
			for(int j=1;j<=5;j++)
				{
				Consumidor b= new Consumidor (buf);
		        Thread t2=new Thread(b);
			    t2.start();
			    }
			System.out.println("Fin del hilo main");
		}
}
