public class Escritor implements Runnable {
private int n;
private Buffer b;
private int m;
public Escritor(Buffer b, int n,int m)
{
	this.b = b;
	this.n = n;
	this.m = m;
}

	@Override
	public void run() {
   try {
	b.escribir(n, m);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   System.out.println("Escritor "+ n + " escribio "+ n);
	}

}