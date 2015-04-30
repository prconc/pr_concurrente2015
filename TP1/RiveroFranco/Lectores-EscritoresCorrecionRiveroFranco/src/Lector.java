
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
				int i=0;
	    while (i<10){
		System.out.println("Lector "+ n + " quiere leer");
		b.leer();
		System.out.println("Lector "+ n + " ha terminado");
		i++;
	    }
		}
	}
