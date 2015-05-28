/*
 * Una tribu de salvajes cenan en comunidad una gran olla que contiene M misioneros cocinados. Cuando un salvaje quiere 
 * comer, él se sirve de la olla un misionero, a menos que este vacía. Si la olla está vacía, el salvaje despierta al 
 * cocinero y espera a que este llene la olla. Desarrollar el código de las acciones de los salvajes y el cocinero 
 * usando monitores.
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Olla olla = new Olla(2, 10);
		
		Monitor mon=new Monitor(olla);//Le doy control de la olla
		
		Salvaje [] s1 = new Salvaje[5];

		Cocinero c1 = new Cocinero();

		c1.setOlla(mon);//paso monitor
		c1.start();

		for(int i=0; i<5; i++){
			s1[i] = new Salvaje(mon);//paso monitor
			s1[i].setName("salvaje "+(i+1));
			s1[i].start();
		}

		for(int i=0; i<5; i++){

			try {
				s1[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print("\nTermino\n");
		System.exit(0);
	}

}


