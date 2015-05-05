public class Filosofo implements Runnable{
   int quienSoy ;
   Palillo derecho, izquierdo;
  public Filosofo(int quienSoy,Palillo derecho, Palillo izquierdo)
  {
  this.quienSoy = quienSoy;
  this.derecho = derecho;
  this.izquierdo = izquierdo;
  }
   public void standBy() throws InterruptedException
   {
   System.out.println("Filosofo " + quienSoy + "esta pensando...");
   Thread.sleep(300);
   }
   synchronized public void actuar() throws InterruptedException
   {
	   while(!derecho.Libre() && !izquierdo.Libre() )
	   {
		   standBy();
	   }
	   izquierdo.agarrar();
	   derecho.agarrar();
	   System.out.println("Filosofo " + quienSoy + " esta comiendo...");
	   Thread.sleep(150);
	   izquierdo.soltar();
	   derecho.soltar();
	   System.out.println("Filosofo " + quienSoy + " uso palillos " + izquierdo.getNum() + " y " + derecho.getNum());
	   notifyAll();
   }
	@Override
	public void run() {
		// TODO Auto-generated method stub
	try {
		actuar();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
}