
public class Main {

	public static void main(String[] args) 
	{
		Buffer buffer = new Buffer();
		Productor productor = new Productor("Productor",buffer);
		Consumidor consumidor = new Consumidor("Consumidor",buffer);
	}

}
