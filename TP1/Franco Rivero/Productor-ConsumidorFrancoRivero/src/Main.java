
public class Main {
	static Buffer buf = new Buffer(5);	
	public static void main(String[] args)
	{
		for(int i= 0; i<1000;i++)
		{Productor p = new Productor(buf,i);
		p.start();}
		for(int j=0;j<1000;j++)
		{Consumidor c1 = new Consumidor(buf,j);
		c1.start();}
			System.out.println("Fin del main");
		
	}
	
}
