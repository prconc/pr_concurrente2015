package principal;

import logica.Monitor;

public class Main {


	public static void main(String[] args) {

		Monitor mon = new Monitor ();

		Filosofos [] f = new Filosofos[5];   // Cantidad de Filosofos

		for  (int i =0 ; i <f.length ; i++){

			f[i] = new Filosofos(i,mon); 

			f[i].start();

		}


	}

}
