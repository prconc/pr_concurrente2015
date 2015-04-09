public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Recurso recurso = new Recurso();
		
		for(int i = 0; i<5;i++){
			
			new Thread(new Escritor(recurso, String.valueOf(i))).start();
			try {
				Thread.sleep((int)(10+Math.random()*(1000)));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			new Thread(new Lector(recurso, String.valueOf(i))).start();
			try {
				Thread.sleep((int)(10+Math.random()*(1000)));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}