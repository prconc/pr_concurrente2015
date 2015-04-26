
public class MainProductorConsumidor {
	
	public static Buffer buf = new Buffer(3);
	public static int num_productores = 5; 
	public static int num_consumidores = 5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=1; i<num_productores; i++){
			Productor p = new Productor(buf, i);
			Thread hp = new Thread(p);
			hp.start();
		}
		for (int j=1; j<num_consumidores; j++){
			Consumidor c = new Consumidor(buf, j);
			Thread hc = new Thread(c);
			hc.start();
		}
		
		//System.out.println("Fin Productor-Consumidor ");
	}

}
