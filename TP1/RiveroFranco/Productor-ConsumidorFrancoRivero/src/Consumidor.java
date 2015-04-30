
public class Consumidor extends Thread{
    int elem;
    Buffer b;
    Consumidor(Buffer b, int n)
    {
    	this.b = b;
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		elem =  b.extract();
		System.out.println("Extrayendo elemento "+elem +  "\n");
	
	}
}