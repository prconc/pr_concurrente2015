
public class Main {

	public static void main(String[] args) 
	{
		Buffer tenedores = new Buffer();
		Filosofo filosofo1=new Filosofo("Pitagoras",0,1,tenedores);
		Filosofo filosofo2=new Filosofo("Aristoteles",1,2,tenedores);
		Filosofo filosofo3=new Filosofo("Platon",2,3,tenedores);
		Filosofo filosofo4=new Filosofo("Euclides",3,4,tenedores);
		Filosofo filosofo5=new Filosofo("Hugo",4,0,tenedores);
	}

}
