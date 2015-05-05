	public class Main {

		public static int cantidad_recursos = 8;
		public static int num_lectores = 5;
		public static int num_escritores = 5;
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Buffer recurso = new Buffer();
			
			for (int i=0; i<num_lectores; i++){
				Lector L = new Lector(recurso, i);//.start();
				Thread hL = new Thread(L); 
				hL.start();
			}
			for (int j=0; j<num_escritores; j++){
				Escritor E = new Escritor(recurso, j);//;.start();
				Thread hE = new Thread(E); 
				hE.start();
			}
		}

	}

