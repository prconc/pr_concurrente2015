public class Main {

	static Buffer buf=new Buffer(3);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=1;i<=100;i++){
			Productor p1=new Productor(buf,i);
		    Consumidor c1=new Consumidor(buf,i);
		    Thread t1=new Thread(p1);
		    Thread t2=new Thread(c1);
		    t1.start();
		    t2.start();
		}
	}

}
