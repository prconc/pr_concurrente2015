public class Semaforos {
		protected int valor;
		private boolean isBinary;
		
		public Semaforos(boolean b, int inicial)
		{
			valor = inicial;
			isBinary = b;
		}
		
		public synchronized void Wait()
		{
			while(valor==0)
			{
				try{wait();}
				catch(InterruptedException e)
				{e.printStackTrace();}
			}
			valor--;
		}
		
		public synchronized void Signal()
		{
			if(isBinary)
			valor = 1;
			else
			valor++;
			
			notify();
		}
		
		public int getValor()
		{
			return valor;
		}
	}

