
/**
 * Clase Semaforo 
 * 
 * Puede ser de dos tipos : Binario (solo valores 0 y 1) o General (valores del 0  en adelante )
 * 
 * El constructor de la Clase recive 2 parametros , un valor inicial y un booleano que le indica si es binario o no 
 * el valor inicial se asocia a la variable contador de la clase y el booleano a la variable esbinario
 */
public class Semaforo {


	protected int contador=0;
	protected boolean esbinario =false;

	public Semaforo(int valorInicial, boolean esbinario_){

		esbinario=esbinario_ ;
		contador=valorInicial;
	}


	synchronized public void WAIT(){
		while(contador==0)
			try{wait();
			}catch(Exception e){}
		contador--;
	}



	synchronized public void SIGNAL(){

		if (esbinario){

			contador =1;
		}else {

			contador++;  

		}
		notify();
	}
}


