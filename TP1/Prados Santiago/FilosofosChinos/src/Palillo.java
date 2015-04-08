

public class Palillo {

	private boolean ocupado=false;
	public int idpalillo;


	Palillo (int idpalillo_){

		idpalillo=idpalillo_ ;

	}

	// Soltar Palillo 

	synchronized void soltar (int idfilo ) {


		ocupado=false;

		System.out.println("Filosofo " + idfilo + " : Suelta el Palillo " + idpalillo  );
		notifyAll();

	}


	//comprobar si el palillo esta ocupado 


	synchronized boolean ocupado() {

		if (ocupado){

			return true;
		}
		else {
			return false ;
		}
	}

	//Tomar el Palillo 

	synchronized void tomar (int idfil){

		System.out.println("Filosofo "+idfil+": Toma el Palillo "+idpalillo);
		ocupado=true;

	}




}
