public class Lector implements Runnable {
private int n;
private Buffer b;
public Lector(Buffer b, int n)
{
	this.b = b;
	this.n = n;
}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Lector "+ b.leer(n) + " Esta leyendo..." + n);
	}
}
